import Navbar from "Pages/Navbar"

export default function HomeLayout({children}){
  return (
    <>
      <Navbar/> 
      {children}
    </>
  )
}