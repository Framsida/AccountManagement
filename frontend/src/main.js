import Vue from 'vue'
import router from './router'
import BootstrapVue from "bootstrap-vue"
import App from './App.vue'
import firebase from 'firebase'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"
import firebaseConfig from './firebaseConfig.js'

Vue.use(BootstrapVue)


let app;
firebase.initializeApp(firebaseConfig);
firebase.auth().onAuthStateChanged(user => {
    if(!app) {
        app = new Vue({
            el: '#app',
            router,
            render: h => h(App)
        })
    }
});