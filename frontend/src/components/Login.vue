<template>
    <b-container class="text-center pt-5" style="max-width: 40rem">
        <b-card class="mx-auto">
            <h2>Login</h2>
            <b-form class="mx-auto pt-4 col-10" @submit="login">
                    <b-form-input id="email_address"
                                  v-model="email"
                                  type="email"
                                  placeholder="Email Address"
                                  class="mb-2">
                    </b-form-input>
                    <b-form-input id="password"
                                  type="password"
                                  v-model="password"
                                  placeholder="Password"
                                  class="mb-4">
                    </b-form-input>

                <div class="text-center mb-2">
                    <b-button type="submit" variant="primary" class="">Login</b-button>
                </div>
            </b-form>
            <p>
                Don't have an account <router-link to="register"> Sign up</router-link>
            </p>
        </b-card>
    </b-container>
</template>

<script>
    import firebase from 'firebase'

    export default {
        name: "Login",

        data() {
            return {
                email: '',
                password: ''
            }
        },

        methods: {
            login(event) {
                event.preventDefault();
                firebase.auth()
                    .signInWithEmailAndPassword(this.email, this.password)
                    .then(
                        user => {
                            alert('You are now logged in')
                        },
                        error => {
                            alert('Something went wrong' + error.message)
                        }
                    )

            }
        }
    }
</script>

<style scoped>

</style>