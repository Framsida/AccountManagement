<template>
    <b-container class="mt-5">
        <b-table hover :items="items" :fields="fields" outlined>
            <template slot="edit" slot-scope="row">
                <b-button size="sm" class="mr-1" variant="primary" @click="editAccount(row.index)">
                    Edit
                </b-button>
                <b-button v-b-modal.confirmDelete @click="markForDelete(row.index, row.item)" size="sm" class="mr-1"
                          variant="danger">
                    Delete
                </b-button>

            </template>
        </b-table>

        <b-modal id="confirmDelete" ref="confirmDelete" title="Confirm Delete"
                 @ok="deleteAccount(indexToDelete, toDelete)">
            <p>
                Please confirm the deletion of
            </p>
            <template v-for="(value, key, index) in toDelete">
                <p>{{key}}: {{value}}</p>
            </template>
        </b-modal>
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
                items: [],
                toDelete: {},
                indexToDelete: ''
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
            deleteAccount(index, account) {
                console.log(account.accountNumber);
                axios
                    .delete('http://localhost:8081/accounts/delete/'+account.accountNumber)
                    .then(response => {
                        if(response.status === 200) {
                            this.items.splice(index, 1)
                        }
                    })
                    .catch(error => {
                        console.log(error)
                    })
            },
            markForDelete(index, account) {
                this.toDelete = account;
                this.indexToDelete = index;
            },
            editAccount(account) {
                this.$router.push('/edit/' + this.items[account].accountID);
            }
        }
    }
</script>

<style scoped>

</style>