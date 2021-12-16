$(async function () {
    await getUsersTable()
})

const userServiceMethodsFetch = {
    head: {
        'Accept': 'application/json',
        'Content-type': 'application/json',
        'Referer': null
    },

    createNewUser: async (user) => await fetch('api/users',
        {
            method: 'POST',
            headers: userServiceMethodsFetch.head,
            body: JSON.stringify(user)
        }
    ),
    findUserById: async (id) => await fetch(`api/users/${id}`),
    getAllUsers: async () => await fetch('/api/users'),
    updateUser: async (user) => await fetch('api/users',
        {
            method: 'PUT',
            headers: userServiceMethodsFetch.head,
            body: JSON.stringify(user)
        }
    ),
    deleteUser: async (id) => await fetch(`api/users/${id}`,
        {
            method: 'DELETE',
            headers: userServiceMethodsFetch.head
        }
    )
}

async function getUsersTable() {
    let table = $('#tableWithUsers tbody');
    table.empty();

    await userServiceMethodsFetch.getAllUsers()
        .then(res => res.json())
        .then(users => {
            users.forEach(user => {
                let output = `$(
                
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${user.roles}</td>
                    <td>
                        <button type="button" data-userid="${user.id}" data-action="edit" class="btn btn-outline-secondary" 
                        data-toggle="modal" data-target="#someDefaultModal"></button>
                    </td>
                    <td>
                         <button type="button" data-userid="${user.id}" data-action="delete" class="btn btn-outline-danger" 
                         data-toggle="modal" data-target="#someDefaultModal"></button>
                    </td>
                </tr>
                )`;
                table.append(output);
            })
        })
}
