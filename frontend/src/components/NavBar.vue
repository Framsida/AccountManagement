<template>
    <b-navbar toggleable="md" type="dark" class="nav-background">
        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
        <b-navbar-brand>Account Manager</b-navbar-brand>
        <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav>
                <b-nav-item>
                    <router-link to="/" class="nav-item">
                        View Accounts
                    </router-link>
                </b-nav-item>
                <b-nav-item href="#">
                    <router-link to="add" class="nav-item">
                        Add Accounts
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
    .nav-item {
        color: aliceblue;
    }

</style>