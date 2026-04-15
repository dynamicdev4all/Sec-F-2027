import React, { useState } from 'react'

const AdminDashboard = () => {

  const [users, setUsers] = useState([
    {
      id: 87234684,
      name: "Shubham Yadav",
      email: "shubham.yadav@yahoo.in",
      upi: "shubham.yadav@icicibank",
      status: true
    },
    {
      id: 64954252,
      name: "Ankit Singh",
      email: "ankit.singh@rdec.in",
      upi: "ankit@kotakbank",
      status: false
    },
    {
      id: 76239431,
      name: "Deepak Kumar",
      email: "deepak.kumar@gmail.in",
      upi: "deepak@kotakbank",
      status: true
    },
  ]);

  const [clickIndex, setClickIndex] = useState()


  const handleAccess = (index) => {
    console.log(index, "is clicked")
    users[index].status = false;
  }

  return (
    <>

      <h1>Admin Dashboard</h1>
      <h1>Total : {users.length}</h1>
      <table border={5}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>UPI</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user, index) => {
            return (
              <tr key={index}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>{user.upi}</td>
                <td>{user.status ? "Active" : "Inactive"}</td>
                <td>
                  <button onClick={() => handleAccess(index)}>{user.status ? "Deactivate" : "Activate"}</button>
                </td>
              </tr>
            )
          })}
        </tbody>
      </table>

    </>
  )
}

export default AdminDashboard