<template>
  <el-form :model="loginForm" :rules="loginRules" ref="loginForm">
    <el-form-item label="username" prop="username">
      <el-input v-model="loginForm.username"></el-input>
    </el-form-item>
    <el-form-item label="password" prop="password">
      <el-input type="password" v-model="loginForm.password"></el-input>
    </el-form-item>
    <el-form-item label="remember" prop="remember">
      <el-switch v-model="loginForm.remember"></el-switch>
    </el-form-item>
    <el-button type="primary" v-on:click="login">Login</el-button>
    <el-button >Signup</el-button>
  </el-form>
</template>

<script>
  import qs from 'qs'
  import ElButton from '../../node_modules/element-ui/packages/button/src/button'
  import ElForm from '../../node_modules/element-ui/packages/form/src/form'
  import ElFormItem from '../../node_modules/element-ui/packages/form/src/form-item'
  import ElInput from '../../node_modules/element-ui/packages/input/src/input'
  import ElSwitch from '../../node_modules/element-ui/packages/switch/src/component'
  export default {
    components: {
      ElSwitch, ElInput, ElFormItem, ElForm, ElButton
    },

    name: 'login',

    data () {
      return {
        loginForm: {
          username: '',
          password: '',
          remember: false
        },

        loginRules: {
          username: [
            {required: true, message: 'Please input your username', trigger: 'blur'},
            {min: 3, max: 5, message: 'length between 3 and 5 characters'}
          ],
          password: [
            {required: true, message: 'Please input your password', trigger: 'blur'},
            {min: 3, max: 5, message: 'length between 3 and 5 characters'}
          ]
        }
      }
    },

    methods: {
      login () {
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.axios({
              method: 'post',
              url: '/login',
              data: {
                username: this.loginForm.username,
                password: this.loginForm.password,
                remember: this.loginForm.remember
              },
              transformRequest: [function (data) {
                return qs.stringify(data)
              }]
            })
              .then(res => {
                console.log(res)
              })
              .then(error => {
                console.log(error)
              })
          } else {
            console.log('error submit')
            return false
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
