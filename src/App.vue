<template>
  <div id="app">
    <router-view />
    <cache-viewer v-if="isCDNEnabled" :visible.sync="showCacheViewer" />
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

.copyright {
  text-align: center;
  color: rgb(0, 0, 0);
  font-size: 12px;
  font-weight: 400;
  margin-top: auto;
  padding: 30px 0 20px;
  position: absolute;
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  width: 100%;
}

.el-message {
  top: 45px !important;
}
</style>
<script>
import CacheViewer from '@/components/CacheViewer.vue';
import { logCacheStatus } from '@/utils/cacheViewer';

export default {
  components: {
    CacheViewer
  },
  data() {
    return {
      showCacheViewer: false,
      isCDNEnabled: process.env.VUE_APP_USE_CDN === 'true'
    };
  },
  mounted() {
    if (this.isCDNEnabled) {
      document.addEventListener('keydown', this.handleKeyDown);
      
      window.checkCDNCacheStatus = () => {
        this.showCacheViewer = true;
      };
      
      console.info(
        '%c[珞小珈服务] CDN缓存检查工具已加载', 
        'color: #409EFF; font-weight: bold;'
      );
      console.info(
        '按下 Alt+C 组合键或在控制台运行 checkCDNCacheStatus() 可以查看CDN缓存状态'
      );
      
      // 检查Service Worker状态
      this.checkServiceWorkerStatus();
    } 
  },
  beforeDestroy() {
    // 只有在启用CDN时才需要移除事件监听
    if (this.isCDNEnabled) {
      document.removeEventListener('keydown', this.handleKeyDown);
    }
  },
  methods: {
    handleKeyDown(e) {
      // Alt+C 快捷键
      if (e.altKey && e.key === 'c') {
        this.showCacheViewer = true;
      }
    },
    async checkServiceWorkerStatus() {
      // 检查Service Worker是否已注册
      if ('serviceWorker' in navigator) {
        try {
          const registrations = await navigator.serviceWorker.getRegistrations();
          if (registrations.length > 0) {
            console.info(
              '%c[珞小珈服务] Service Worker已注册', 
              'color: #67C23A; font-weight: bold;'
            );
            
            // 输出缓存状态到控制台
            setTimeout(async () => {
              const hasCaches = await logCacheStatus();
              if (!hasCaches) {
                console.info(
                  '%c[珞小珈服务] 还未检测到缓存，请刷新页面或等待缓存建立', 
                  'color: #E6A23C; font-weight: bold;'
                );
                
                // 开发环境下提供额外提示
                if (process.env.NODE_ENV === 'development') {
                  console.info(
                    '%c[珞小珈服务] 在开发环境中，Service Worker可能无法正常初始化缓存',
                    'color: #E6A23C; font-weight: bold;'
                  );
                  
                }
              }
            }, 2000);
          } else {
            console.info(
              '%c[珞小珈服务] Service Worker未注册，CDN资源可能无法缓存', 
              'color: #F56C6C; font-weight: bold;'
            );
            
            if (process.env.NODE_ENV === 'development') {
              console.info(
                '%c[珞小珈服务] 在开发环境中，这是正常现象',
                'color: #E6A23C; font-weight: bold;'
              );
              
            }
          }
        } catch (error) {
          console.error('检查Service Worker状态失败:', error);
        }
      } else {
        console.warn('当前浏览器不支持Service Worker，CDN资源缓存功能不可用');
      }
    }
  }
};
</script>