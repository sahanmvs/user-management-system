import { signIn } from 'next-auth/react'
import React from 'react'
import Navbar from './Navbar'

const Login = () => {
  return (
    <div>
        <Navbar />
        <div className='container mx-2 my-8'>
            <div className='h-12'>
                <button
                    onClick={signIn} 
                    className='rounded bg-blue-500 text-white px-4 py-2'>
                    Sign In
                </button>
            </div>
        </div>
    </div>
  )
}

export default Login