<template>
    <b-container class="mt-5">
        <b-table hover :items="items" :fields="fields" outlined>
            <template slot="edit" slot-scope="row">
                <b-button size="sm" class="mr-1" variant="primary">
                    Edit
                </b-button>
                <b-button @click="deleteAccount(row.item.index, row.item.accountNumber)" size="sm" class="mr-1" variant="danger">
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
                items: []
            }
        },
        mounted() {
            axios
                .get('http://localhost:8081/accounts/all')
                .then(response => {
                    this.items = response.data;
                }).catch(error => {
                    console.log(error)
            })
        },
        methods: {
            deleteAccount(index, accountNumber) {
                console.log(accountNumber);
                axios
                    .delete('http://localhost:8081/accounts/delete/'+accountNumber)
                    .then(response => {
                        if(response.status === 200) {
                            this.items.splice(index, 1)
                        }
                    })
                    .catch(error => {
                        console.log(error)
                    })
            }
        }
    }
</script>

<style scoped>

</style>