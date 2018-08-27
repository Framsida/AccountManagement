import Vue from 'vue'
import Router from 'vue-router'
import AccountsList from '../components/AccountsList.vue'
import AddAccount from '../components/AddAccount.vue'


Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Hello',
            component: AccountsList
        },
        {
          path: '/add',
          name: 'AddAccount',
          component: AddAccount
        }
    ]
})