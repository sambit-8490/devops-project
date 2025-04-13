import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/member';

// to get all members from the database
export const listMembers = () => axios.get(REST_API_BASE_URL + '/'+ 'members');

// to save member data to the database
export const createMember = (member) =>axios.post(REST_API_BASE_URL, member);

// to get member by id
export const getMemberById = (memberId) => axios.get(REST_API_BASE_URL + '/' + memberId);

// to update member data in the database
// export const updateMember = (member, memberId) => axios.put(REST_API_BASE_URL + '/' + memberId, member);
export const updateMember = (member) => axios.put(REST_API_BASE_URL, member);

// to delete member from the database
export const deleteMember = (memberId) => axios.delete(REST_API_BASE_URL + '/' + memberId);
