<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <ul>
      <li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>
      <li><a href="https://gitter.im/vuejs/vue" target="_blank">Gitter Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>
      <br>
      <li><a href="http://vuejs-templates.github.io/webpack/" target="_blank">Docs for This Template</a></li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li>
      <li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li>
      <li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li>
    </ul>
    <div><a v-on:click="testClick()">test</a></div>
    <li v-for="food in foodList">
      {{ food.productId }}
      {{ food.productName }}
      {{ food.productPrice }}
    </li>
    <h2>{{ code }}</h2>
    <button v-on:click="testGet()">get</button>
    <button v-on:click="testGetFood()">getFood</button>
    <button v-on:click="testPost()">post</button>
    <button v-on:click="testPut()">put</button>
    <button v-on:click="testDelete()">delete</button>
  </div>
</template>

<script>
import qs from 'qs'
//var instance = this.axios.create({
//  baseURL: '/user',
//  timeout: 1000,
//  transformRequest: [function (data) {
//    // Do whatever you want to transform the data
//    return data
//  }],
//  data: {
//    userName: 'Ethan',
//    password: '2222'
//  }
//})
export default {
  name: 'hello',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      foodList: [],
      code: 100,
      id: 1
    }
  },
  methods: {
    testClick: function () {
      this.axios.get('/food').then(res => {
//        this.foodList = res.data.result.list
        this.code = res.data.code
//        console.log(this.foodList)
      })
    },
//    testPost: function () {
////      this.axios.post('/user', {
////        userName: 'Ethan',
////        password: 2222
////      })
////        .then(res => {
////          console.log(res)
////        })
////        .then(error => {
////          console.log(error)
////        })
//      const data = new FormData();
//      data.append("userName", 'Ethan')
//      this.axios({
//        method: 'post',
//        url: '/user',
//        data:
////          qs.stringify({
////            userName: 'Ethan1',
////            name: 'Ethan2'
////          }),
//          {
//            userName: 'Ethan',
//            password: 2222
//          },
////        params: {
////          name: 'Ethan1'
////        },
//        transformRequest: [function (data) {
//          // Do whatever you want to transform the data
//          return qs.stringify(data)
//        }],
//        headers: {'X-Requested-With': 'XMLHttpRequest',
//                  'Content-Type': 'application/x-www-form-urlencoded'}
//      })
//        .then(res => {
//          console.log(res)
//        })
//    },
    testGet: function () {
      this.axios({
        method: 'get',
        url: 'food'
      })
        .then(res => {
          this.foodList = res.data.data
          console.log(res)
        })
        .then(error => {
          console.log(error)
        })
    },
    testGetFood: function () {
      this.axios({
        method: 'get',
        url: 'food/' + this.id
      })
        .then(res => {
          this.foodList = res.data.data
          console.log(res)
        })
        .then(error => {
          console.log(error)
        })
    },
    testPost: function () {
      this.axios({
        method: 'post',
        url: 'food',
        data: {
          productId: 4,
          productName: 'drink',
          productPrice: 0.2
        },
        transformRequest: [function (data) {
          return qs.stringify(data)
        }]
      })
        .then(res => {
          this.foodList = res.data.data
          console.log(res)
        })
        .then(error => {
          console.log(error)
        })
    },
    testPut: function () {
      this.axios({
        method: 'put',
        url: '/food/1',
        params: {
          productName: 'snack',
          productPrice: 60.6
        }
      })
        .then(res => {
          this.foodList = res.data.data
          console.log(res)
        })
        .then(error => {
          console.log(error)
        })
    },
    testDelete: function () {
      this.axios({
        method: 'delete',
        url: 'food/3'
      })
        .then(res => {
          this.foodList = res.data.data
          console.log(res)
        })
        .then(error => {
          console.log(error)
        })
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
