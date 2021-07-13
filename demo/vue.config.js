module.exports = {
    devServer: {
        proxy: {
            '/g2': {
                target: 'https://view.inews.qq.com',
                changeOrigin: true,
            },
            '/news/wap': {
                target: 'https://interface.sina.cn',
                changeOrigin: true,
            },
            // '/api': {
            //     target: 'http://localhost:8888',
            //     changeOrigin: true,
            //     pathRewrite:{'^/api': ""},
            // }
            '/ug': {
                target: 'https://c.m.163.com',
                changeOrigin: true
            },
            '/newsqa': {
                target: 'https://api.inews.qq.com',
                changeOrigin: true
            },
            
        },
    }
}