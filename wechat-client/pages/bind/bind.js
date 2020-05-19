// pages/bind/bind.js
Page({

 

  /**
   * 页面的初始数据
   */
  data: {

  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  

     /**
   *  自定义函数
   *  函数名:function(){
   *    
   *  }
   */
  printName:function(){
    console.log("打印自己名字的函数");
  },

  doLogin:function(e){
    //console.log("进入登录事件" + e.detail.value.uname); //输出表单的数据
    wx.request({
      url:"http://localhost:8848/doLogin",
      method:"post",
      header:{
        "Content-Type": "application/x-www-form-urlencoded" 
      },
      data:{
        uname:e.detail.value.uname,
        upassword:e.detail.value.upassword
      },
      success:function(res){
        console.log(res);
        if(res.data.code == 200){
          if(res.data.result=="登录成功"){
            console.log("登录成功！");
            
            wx.reLaunch({
              url: '../list/list'
            })
          }else{
            wx.showToast({ title: '用户名或密码有误', icon: 'none', duration: 2000 })
            console.log("登录失败！");
          }
        }
      },
      fail:function(res){
        console.log("登陆失败！");
      }
      
    })

  }
  
})