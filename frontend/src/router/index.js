import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Login from '@/components/Login'
import Product from '@/components/Product'
import Management from '@/components/Management'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/product',
      name: 'Product',
      component: Product
    },
    {
      path: '/management',
      name: 'Management',
      component: Management
    }
  ]
})
