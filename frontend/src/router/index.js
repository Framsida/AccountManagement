import Vue from 'vue'
import Router from 'vue-router'
import firebase from 'firebase'


import AccountsList from '../components/AccountsList.vue'
import AddAccount from '../components/AddAccount.vue'
import EditAccount from '../components/EditAccount.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'



Vue.use(Router);

let router = new Router({
    routes: [
        {
            path: '*',
            redirect: '/login'
        },
        {
            path: '/',
            name: 'AccountsList',
            component: AccountsList,
            meta: {
                requireAuth: true
            }
        },
        {
            path: '/add',
            name: 'AddAccount',
            component: AddAccount,
            meta: {
                requireAuth: true
            }
        },
        {
            path:'/edit/:id',
            name: 'EditAccount',
            component: EditAccount,
            props: true,
            meta: {
                requireAuth: true
            }
        },
        {
            path:'/login',
            name: 'Login',
            component: Login

        },
        {
            path:'/register',
            name: 'Register',
            component: Register,
            meta: {
                requireAuth: false
            }
        }
    ]
});

router.beforeEach((to, from, next) => {
    let currentUser = firebase.auth().currentUser;
    let requiresAuth = to.matched.some(record => record.meta.requireAuth);

    if (requiresAuth && !currentUser) {
        next('login');
    }
    else if (!requiresAuth && currentUser) {
        next('/');
    }
    else {
        next();
    }
});

export default router
