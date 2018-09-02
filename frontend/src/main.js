import Vue from 'vue'
import router from './router'
import BootstrapVue from "bootstrap-vue"
import App from './App.vue'
import firebase from 'firebase'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"
import firebaseConfig from './firebaseConfig.js'

Vue.use(BootstrapVue)


firebase.initializeApp(firebaseConfig);

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})
