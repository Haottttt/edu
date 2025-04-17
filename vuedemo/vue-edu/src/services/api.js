import axios from 'axios'

const api = axios.create({
  baseURL: '/',   // 开发环境由 vue.config.js 转发到各后端微服务
  timeout: 5000
})

export default {
  // ----------------- 用户 -----------------
  register(data) {
    return api.post('/user/register', data)
  },
  login(username, password) {
    const params = new URLSearchParams()
    params.append('username', username)
    params.append('password', password)
    return api.post('/user/login', params)
  },

  // ----------------- 课程 -----------------
  getCourses() {
    return api.get('/course/all')
  },
  getCourseDetail(id) {
    return api.get('/course/all')  // 如果后端没有单独详情接口，可前端自行过滤
      .then(r => r.data.find(c => c.id === +id))
  },
  enrollCourse(studentId, courseId) {
    return api.post('/enroll/', null, { params: { studentId, courseId } })
  },
  getMyEnrollments(studentId) {
    return api.get(`/enroll/student/${studentId}`)
  },

  // ----------------- 视频 -----------------
  getVideos(courseId) {
    return api.get(`/video/course/${courseId}`)
  },

  // ----------------- 作业 -----------------
  submitHomework(homework) {
    return api.post('/homework/submit', homework)
  },
  getMyHomework(studentId) {
    return api.get(`/homework/student/${studentId}`)
  },

  // ----------------- 下单 & 支付 -----------------
  createOrder(studentId, courseId, amount) {
    return api.post('/order/create', null, { params: { studentId, courseId, amount } })
  },
  payOrder(orderId, method) {
    return api.post('/payment/pay', null, { params: { orderId, method } })
  },
  getOrdersByStudent(studentId) {
    return api.get('/order', { params: { studentId } })
  },

  // ----------------- 聊天 -----------------
  sendMessage(msg) {
    return api.post('/messages/', msg)
  },
  fetchHistory(chatId) {
    return api.get(`/messages/chat/${chatId}`)
  },

  // ----------------- 通知 & 退款 等可按需补充 -----------------
}
