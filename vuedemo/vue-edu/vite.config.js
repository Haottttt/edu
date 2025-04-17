
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig({
  plugins: [ vue() ],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src')    // 把 @ 映射到 src 文件夹
    }
  },
  server: {
    proxy: {
      '/user':     { target: 'http://localhost:8080', changeOrigin: true },
      '/course':   { target: 'http://localhost:8082', changeOrigin: true },
      '/enroll':   { target: 'http://localhost:8082', changeOrigin: true },
      '/video':    { target: 'http://localhost:8082', changeOrigin: true },
      '/homework': { target: 'http://localhost:8083', changeOrigin: true },
      '/order':    { target: 'http://localhost:8084', changeOrigin: true },
      '/payment':  { target: 'http://localhost:8084', changeOrigin: true },
      '/messages': { target: 'http://localhost:8081', changeOrigin: true }
    }
  }
})
