import { getSession } from 'next-auth/react'
import Head from 'next/head'
import AddUser from '../components/AddUser'
import Login from '../components/Login'
import Navbar from '../components/Navbar'

export default function Home({ session }) {
  if (!session) return <Login />
  return (
    <div>
      <Head>
        <title>User Management App</title>
      </Head>
      <Navbar />
      <main className='mx-10'>
        <AddUser />
      </main>

    </div>
  )
}

export async function getServerSideProps(context) {
  const session = await getSession(context);
  return {
    props: { session }
  }
}
