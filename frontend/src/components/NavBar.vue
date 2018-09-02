<template>
    <b-navbar toggleable="md" type="dark" class="nav-background">
        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
        <b-navbar-brand>Account Manager</b-navbar-brand>
        <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav>
                <b-nav-item>
                    <router-link to="/">
                        View Accounts
                    </router-link>
                </b-nav-item>
                <b-nav-item href="#" class="mr-5">
                    <router-link to="add">
                        Add Accounts
                    </router-link>
                </b-nav-item>

            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-item v-if="loggedIn">
                    Sign out
                </b-nav-item>
                <b-nav-item v-else>
                    <router-link to="login" class="mr-3">
                        Login
                    </router-link>
                    <router-link to="register" class="mr-2">
                        Register
                    </router-link>
                </b-nav-item>
            </b-navbar-nav>
        </b-collapse>
    </b-navbar>
</template>

<script>
    import firebase from 'firebase'
    export default {
        name: "NavBar",
        data() {
            return {
                loggedIn: false,
            }
        },
        mounted() {
            if(firebase.auth.currentUser) {
                this.loggedIn = true;
            }
            console.log(this.loggedIn);
        }
    }
</script>

<style scoped>
    .nav-background {
        background-color: dimgray;
    }
    a {
        color: inherit;
    }

</style>