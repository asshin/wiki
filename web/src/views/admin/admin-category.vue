<template>
  <a-layout>

    <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <p>
        <a-form layout="inline" :model="param">
          <a-form-item>
            <a-button type="primary" @click="handleQuery()">
              刷新
            </a-button>
          </a-form-item>
          <a-form-item>
            <a-button type="primary" @click="add()">
              新增
            </a-button>
          </a-form-item>
        </a-form>
      </p>

          <a-table
                  :columns="columns"
                  :row-key="record => record.id"
                  :data-source="categorys"
                  :pagination="false"
                  :loading="loading"
                  @change="handleTableChange"

          >
            <template #cover="{ text: cover }">
              <img v-if="cover" :src="cover" alt="avatar" />
            </template>
            <template v-slot:action="{ text, record }">
              <a-space size="small">
                <a-button type="primary" @click="edit(record)">
                  编辑
                </a-button>
                <a-popconfirm
                        title="Are you sure delete this task?"
                        ok-text="Yes"
                        cancel-text="No"
                        @confirm="deleteById(record.id)"
                >
                  <a-button type="danger">
                    删除
                  </a-button>
                </a-popconfirm>

              </a-space>
            </template>
          </a-table>



    </a-layout-content>
  </a-layout>
  <a-modal
          title="电子书表单"
          v-model:visible="modalVisible"
          :confirm-loading="modalLoading"
          @ok="handleModalOk"
  >
    <a-form :model="category" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="id">
        <a-input v-model:value="category.id" />
      </a-form-item>
      <a-form-item label="名称">
        <a-input v-model:value="category.name" />
      </a-form-item>
      <a-form-item label="父分类">
        <a-input v-model:value="category.parent" />
      </a-form-item>
      <a-form-item label="排序">
        <a-input v-model:value="category.sort" type="textarea" />
      </a-form-item>
    </a-form>
  </a-modal>
</template>
<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import axios from 'axios';
  import { message } from 'ant-design-vue';
  import {Tool} from "@/util/tool";
  export default defineComponent({
    name: 'AdminEbook',
    setup() {
      const param=ref();
      param.value={};
      const categorys = ref();
      const pagination = ref({
        current: 1,
        pageSize:5,
        total: 0
      });
      const loading = ref(false);

      const columns = [
        {
          title: 'id',
          dataIndex: 'id',
          slots: { customRender: 'id' }
        },
        {
          title: '名称',
          dataIndex: 'name'
        },
        {
          title: '父分类',
          key: 'parent',
          dataIndex: 'parent'
        },
        {
          title: '排序',
          dataIndex: 'sort'
        },
        {
          title: 'Action',
          key: 'action',
          slots: { customRender: 'action' }
        }
      ];

      /**
       * 数据查询
       **/
      const handleQuery = () => {
        loading.value = true;
        axios.get("/category/all").then((response) => {
          loading.value = false;
          const data = response.data;
          if (data.success) {
             categorys.value = data.content;
          }else {
            message.error(data.message);
          }

        });
      };

      /**
       * 表格点击页码时触发
       */
      const handleTableChange = (pagination: any) => {
        console.log("看看自带的分页参数都有啥：" + pagination.current);
        handleQuery();
      };
      // -------- 表单 ---------
      const category = ref({});
      const modalVisible = ref(false);
      const modalLoading = ref(false);
      const handleModalOk = () => {
        modalLoading.value = true;
        axios.post("/category/save",category.value).then((response) => {
          modalLoading.value = false;
          const data = response.data;
          if(data.success){
            modalVisible.value=false;
            handleQuery();
          }else {
            message.error(data.message)
          }

        });

      };

      /**
       * 编辑
       */
      const edit = (record:any) => {
                console.log("record is this:"+record)
                modalVisible.value = true;
                category.value=Tool.copy(record);
              };
      /**
       * 新增
       */
      const add = () => {
        modalVisible.value = true;
        category.value={};
      };
      /**
       * 删除通过id
       */
      const deleteById = (id:number) => {
        axios.delete("/category/delete/"+id).then((response) => {
          const data = response.data;
          if(data.success){
            handleQuery();
          }

        });


      };

      onMounted(() => {
        handleQuery();
      });

      return {
        param ,
        category,
        categorys,
        pagination,
        columns,
        loading,
        handleTableChange,
        handleQuery,

        edit,
        add,
        deleteById,

        modalVisible,
        modalLoading,
        handleModalOk
      }
    }
  });
</script>
<style scoped>
  img {
    width: 50px;
    height: 50px;
  }
</style>
