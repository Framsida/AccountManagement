<template>
    <div id="app">
        <NavBar></NavBar>
        <router-view/>
    </div>
</template>

<script>
    import AccountsList from './components/AccountsList.vue'
    import NavBar from './components/NavBar.vue'
    import AddAccount from './components/AddAccount.vue'
    export default {
        components: {
            AccountsList,
            NavBar,
            AddAccount
        },

        name: 'app',
        data () {
            return {
                msg: 'Welcome to Your Vue.js App'
            }
        }
    }
</script>

<style>

</style>
