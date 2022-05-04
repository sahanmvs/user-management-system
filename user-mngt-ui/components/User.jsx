import React from 'react'

const User = ({ user, deleteUser, editUser }) => {
  return (
    <tr key={user.id}>
        <td className='text-left py-3 px-6 whitespace-nowrap'>
            <div className='text-sm text-gray-700'>{user.firstName}</div></td>
        <td className='text-left py-3 px-6 whitespace-nowrap'>
            <div className='text-sm text-gray-700'>{user.lastName}</div></td>
        <td className='text-left py-3 px-6 whitespace-nowrap'>
            <div className='text-sm text-gray-700'>{user.email}</div></td>
        <td className='text-right py-3 px-6 whitespace-nowrap'>
            <a 
                onClick={(e, id) => editUser(e, user.id)}
                className='text-indigo-500 hover:text-indigo-800 hover:cursor-pointer px-6'>Edit
            </a>
            <a  
                onClick={(e, id) => deleteUser(e, user.id)}
                className='text-red-500 hover:text-red-800 hover:cursor-pointer'>Delete
            </a>
        </td>    
    </tr>
  )
}

export default User