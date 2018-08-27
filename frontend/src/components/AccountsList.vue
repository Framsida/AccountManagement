<template>
    <b-container class="mt-5">
        <b-table hover :items="items" :fields="fields" outlined>
            <template slot="edit" slot-scope="row">
                <b-button size="sm" class="mr-1" variant="primary">
                    Edit
                </b-button>
                <b-button @click="deleteAccount(items.accountNumber)" size="sm" class="mr-1" variant="danger">
                    Delete
                </b-button>
            </template>
        </b-table>
    </b-container>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "AccountsList",
        data() {
            return {
                fields: [
                    {
                        key: 'accountNumber',
                        label: 'Account ID'
                    },
                    {
                        key: 'firstName',
                        label: 'First Name',
                        sortable: false
                    },
                    {
                        key: 'lastName',
                        label: 'Last Name'
                    },
                    {
                        key: 'emailAddress',
                        label: 'Email Address'
                    },
                    {
                        key: 'edit',
                        label: "",
                        edit: 'test'
                    }
                ],
                items: [
                    {
                        accountID:'001',
                        first_name: 'Joe',
                        last_name: 'Blogs',
                        email: 'JoeBlogs@gmail.com',
                        edit: '<b-button>TEST</b-button>'
                    },
                    {
                        accountID:'002',
                        first_name: 'Steve',
                        last_name: 'Steverson',
                        email: 'Steve@gmail.com'
                    },
                    {
                        accountID:'003',
                        first_name: 'Kate',
                        last_name: 'Kat',
                        email: 'Kate@gmail.com'
                    }
                ]
            }
        },
        mounted() {
            axios
                .get('http://localhost:8081/accounts/all')
                .then(response => {
                    this.items = response.data;
                    console.log(response.data);
                    console.log(response.status);
                    console.log(response.headers);
                    console.log('mounted');
                }).catch(error => {
                    console.log(error)
            })
        },
        methods: {
            deleteAccount(accountNumber) {
            }
        }
    }
</script>

<style scoped>

</style>