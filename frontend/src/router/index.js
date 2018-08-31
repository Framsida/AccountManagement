import Vue from 'vue'
import Router from 'vue-router'
import AccountsList from '../components/AccountsList.vue'
import AddAccount from '../components/AddAccount.vue'
import EditAccount from '../components/EditAccount.vue'


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
        },
        {
            path:'/edit/:id',
            name: 'EditAccount',
            component: EditAccount,
            props: true
        }
    ]
})