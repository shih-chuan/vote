import { toast } from "vue3-toastify"
import axios from 'axios'

const errorHandle = (status, msg) => {
  switch (status) {
    case 400:
      toast.error(msg)
      break
    default:
      console.error(msg)
  }
}

export const api = axios.create({baseURL: 'http://localhost:8080/'})

api.interceptors.request.use((config) => {
  return config
}, (error) => {
  return Promise.reject(error)
})

export default function (method, url, data=null) {
  method = method.toLowerCase()
  switch (method) {
    case 'post':
      return api.post(url, data)
    case 'get':
      return api.get(url, {params: data})
    case 'delete':
      return api.delete(url, {params: data})
    case 'put':
      return api.put(url, data)
    default:
      console.error("unknown method " + method)
      return false
  }
}
