<template>
    <b-container class="text-center pt-5" style="max-width: 40rem">
        <b-card class="mx-auto">
            <h2>Register</h2>
            <b-form class="mx-auto pt-4 col-10" @submit="register">
                <b-form-input id="email_address"
                              v-model="email"
                              placeholder="Email Address"
                              type="email"
                              class="mb-2">

                </b-form-input>
                <b-form-input id="password"
                              type="password"
                              v-model="password"
                              placeholder="Password"
                              class="mb-2">
                </b-form-input>
                <b-form-input id="password"
                              type="password"
                              v-model="passwordConfirm"
                              placeholder="Confirm Password"
                              class="mb-4">

                </b-form-input>
                <div class="text-center mb-2">
                    <b-button type="submit" variant="primary" class="">Register</b-button>
                </div>
                <p>
                    Already registered? <router-link to="login">Login Now</router-link>
                </p>
            </b-form>
        </b-card>
    </b-container>
</template>

<script>
    import firebase from 'firebase'

    export default {
        name: "Register",

        data() {
            return {
                email: '',
                password: ''
            }
        },

        methods: {
            register(event) {
                firebase.auth()
                    .createUserWithEmailAndPassword(this.email, this.password)
                    .then(
                        user => {
                            alert('User created')
                        },
                        error => {
                            alert('Something went wrong' + error.message)
                        }
                    )
                event.preventDefault();

            }
        }
    }
</script>

<style scoped>

</style>