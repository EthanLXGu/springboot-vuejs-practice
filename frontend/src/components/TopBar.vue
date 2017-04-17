<template>
  <el-row>
    <el-menu theme="dark" :default-active="activeIndex" mode="horizontal">
     <el-col :span="12">
       <el-menu-item index="1" route="" disabled=""><router-link to="/">Home</router-link></el-menu-item>
       <el-menu-item index="2" route="" disabled=""><router-link to="/product">Product</router-link></el-menu-item>
       <el-menu-item index="6" route="" disabled=""><router-link to="/management">Product Management</router-link></el-menu-item>
     </el-col>
     <el-col :span="5" :offset="7" type="flex" justify="right">
       <el-submenu index="3">
         <template slot="title" >Lists</template>
         <el-menu-item index="2-1">List1</el-menu-item>
         <el-menu-item index="2-2">List2</el-menu-item>
         <el-menu-item index="2-3">List3</el-menu-item>
       </el-submenu>
       <el-menu-item index="4" route="" disabled=""><router-link to="/login">Login</router-link></el-menu-item>
       <el-menu-item index="5" route="" disabled="">Signup</el-menu-item>
     </el-col>
    </el-menu>
  </el-row>
</template>

<script>
  import ElMenu from '../../node_modules/element-ui/packages/menu/src/menu'
  import ElMenuItem from '../../node_modules/element-ui/packages/menu/src/menu-item'
  import ElRow from '../../node_modules/element-ui/packages/row/src/row'
//  import ElCol from 'element-ui/packages/col/src/col'
  export default {
    components: {ElRow, ElMenuItem, ElMenu},

    name: 'TopBar',

    data () {
      return {
      }
    }
  }
</script>

<style>
</style>
