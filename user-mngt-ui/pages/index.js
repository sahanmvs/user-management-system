import Head from 'next/head'
import AddUser from '../components/AddUser'
import Navbar from '../components/Navbar'

export default function Home() {
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
