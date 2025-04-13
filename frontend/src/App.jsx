import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import HomeComponent from './components/HomeComponent'
import ListAuthorComponent from './components/ListAuthorComponent'
import ListBookComponent from './components/ListBookComponent'
import ListMemberComponent from './components/ListMemberComponent'
import ListLoanComponent from './components/ListLoanComponent'
import AddMemberComponent from './components/AddMemberComponent'
import AddAuthorComponent from './components/AddAuthorComponent'
import AddBookComponent from './components/AddBookComponent'
import AddLoanComponent from './components/AddLoanComponent'

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<HomeComponent />} />         {/* http://localhost:3000/ */}
          <Route path="/authors" element={<ListAuthorComponent />} />   {/* http://localhost:3000/authors */}
          <Route path="/books" element={<ListBookComponent />} />       {/* http://localhost:3000/books */}
          <Route path="/members" element={<ListMemberComponent />} />   {/* http://localhost:3000/members */}
          <Route path="/loans" element={<ListLoanComponent />} />       {/* http://localhost:3000/loans */}
          <Route path='/add-member' element={<AddMemberComponent />} /> {/* http://localhost:3000/add-member */}
          <Route path='/add-author' element={<AddAuthorComponent />} /> {/* http://localhost:3000/add-author */}
          <Route path='/add-book' element={<AddBookComponent />} />     {/* http://localhost:3000/add-book */}
          <Route path='/add-loan' element={<AddLoanComponent />} />     {/* http://localhost:3000/add-loan */}
          <Route path='*' element={<h1>404 Not Found</h1>} />           {/* http://localhost:3000/anything-else */}
          <Route path='/edit-member/:id' element={<AddMemberComponent />} /> {/* http://localhost:3000/edit-employee/1 */}
        </Routes>
      </BrowserRouter>
    </>
  )
}
export default App;