<template>
    <div>
        <NavBar></NavBar>
    <b-container class="mt-5">
        <b-table hover :items="items" :fields="fields" outlined :sort-by.sync="items.accountNumber">
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
            <div class="ml-3">
                <p>
                    Please confirm the deletion of
                </p>
                <p>
                    Name: {{toDelete.firstName}} {{toDelete.lastName}}
                </p>
                <p>
                    Account Number: {{toDelete.accountNumber}}
                </p>
            </div>
        </b-modal>
    </b-container>
    </div>
</template>

<script>
    import axios from 'axios'
    import NavBar from "./NavBar.vue";

    export default {
        name: "AccountsList",
        components: {NavBar},
        data() {
            return {
                fields: [
                    {
                        key: 'accountNumber',
                        label: 'Account ID',
                        sortable: true
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
            })
        },
        methods: {
            deleteAccount(index, account) {
                axios
                    .delete('http://localhost:8081/accounts/delete/'+account.id)
                    .then(response => {
                        if(response.status === 200) {
                            this.items.splice(index, 1)
                        }
                    })
                    .catch(error => {
                    })
            },
            markForDelete(index, account) {
                this.toDelete = account;
                this.indexToDelete = index;
            },
            editAccount(accountIndex) {

                this.$router.push({
                    path: '/edit/' + this.items[accountIndex].id,
                    params: this.items[accountIndex].accountNumber
                });
            }
        }
    }
</script>

<style scoped>

</style>