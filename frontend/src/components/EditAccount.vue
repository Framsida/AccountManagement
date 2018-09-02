<template>
    <b-container class="mt-5">
        <b-card>
        <b-form @submit="onSubmit" @reset="onCancel">
            <div class="row">
                <div class="col-md-6">
                    <b-form-group id="first_name_group"
                                  label="First Name"
                                  label-for="first_name">
                        <b-form-input id="first_name"
                                      type="text"
                                      required
                                      placeholder="Enter first name"
                                      v-model="account.firstName">

                        </b-form-input>

                </b-form-group>
                </div>
                <div class="col-md-6">
                    <b-form-group id="last_name_group"
                                  label="Last Name"
                                  label-for="last_name">
                        <b-form-input id="last_name"
                                      type="text"
                                      required
                                      placeholder="Enter last name"
                                      v-model="account.lastName">
                        </b-form-input>
                    </b-form-group>
                </div>
            </div>
            <b-form-group id="email_group"
                          label="Email Address"
                          label-for="email">
                <b-form-input id="email"
                              type="email"
                              required
                              placeholder="Enter their email address"
                              v-model="account.emailAddress">
                </b-form-input>
            </b-form-group>
            <b-form-group id="account_number_group"
                          label="Account Number"
                          label-for="account_number">
                <b-form-input id="account_number"
                              class="col-4"
                              type="text"
                              v-model="account.accountNumber"
                              readonly>
                </b-form-input>
            </b-form-group>
            <b-button type="submit" variant="primary">Save Changes</b-button>
            <b-button type="reset" variant="secondary">Cancel changes</b-button>
        </b-form>
        </b-card>
    </b-container>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "AddAccount",
        data() {
            return {
                formInputs: [
                    {
                        id: "first_name",
                        label: "First Name"
                    },
                    {
                        id: "last_name",
                        label: "Last Name"

                    },
                    {
                        id: "email",
                        label: "Email Address"

                    },
                    {
                        id: "account_number",
                        label: "Account Number"

                    }

                ],
                account: {
                    accountNumber:'',
                    firstName: '',
                    lastName: '',
                    emailAddress: ''
                }

            }
        },
        methods: {
            onSubmit(event) {
                event.preventDefault();
                axios.put('http://localhost:8081/accounts/', this.account)
                    .then(response => {
                        if(response.status === 200) {
                            this.$router.push('/');
                        }
                    })
                    .catch(error => {
                        console.log(error)
                    });
            },
            onCancel(event) {
                event.preventDefault();
                this.$router.push('/');
            }
        },
        mounted() {
            console.log(this.$route.params.id);
            axios
                .get(`http://localhost:8081/accounts/1001`)
                .then(response => {
                    this.account = response.data[0];
                }).catch(error => {
                console.log(error)
            });
        }
    }
</script>

<style scoped>

</style>