<template>
  <el-table height="250" :data="tableData" stripe border style="width: 100%" :default-sort="{prop: 'date', order: 'descending'}">
    <el-table-column fixed prop="date" label="Created Date" width="180" sortable></el-table-column>
    <el-table-column prop="name" label="name" width="180"></el-table-column>
    <el-table-column prop="address" label="address" width="180" :formatter="formatter"></el-table-column>
    <el-table-column fixed='right' prop="tag" label="Tag" width="180" :filters="[{ text: 'Home', value: 'home' }, { text: 'Company', value: 'company' }]" :filter-method="filterTag">
      <template scope="scope">
        <el-tag :type="scope.row.tag === 'home' ? 'primary' : 'success'" close-transition>{{scope.row.tag}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column fixed="right" label="operation" width="200">
      <template scope="scope">
        <el-button @click="" type="text" size="small">View</el-button>
        <el-button @click="" type="text" size="small">Edit</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  import ElButton from '../../node_modules/element-ui/packages/button/src/button'
  import ElTag from '../../node_modules/element-ui/packages/tag/src/tag'
//  import ElTable from '../../node_modules/element-ui/packages/table/src/table'
  export default {
    components: {ElTag, ElButton},

    name: 'Management',

    data () {
      return {
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          tag: 'home'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄',
          tag: 'company'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          tag: 'home'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄',
          tag: 'company'
        }]
      }
    },

    methods: {
      formatter (row, column) {
        return row.address
      },
      filterTag (value, row) {
        return row.tag === value
      }
    }
  }
</script>

<style>

</style>
