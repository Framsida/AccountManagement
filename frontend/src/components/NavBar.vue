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
                <b-nav-form>
                    <b-form-input size="sm" type="text" paceholder="Search" class="mr-3"/>
                    <b-button size="sm">Search</b-button>
                </b-nav-form>

            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-item>
                    <router-link to="login">
                        Login
                    </router-link>
                </b-nav-item>
            </b-navbar-nav>
        </b-collapse>
    </b-navbar>
</template>

<script>
    export default {
        name: "NavBar"
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