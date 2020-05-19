// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    uid:null,
    name:'',
    age:'',
    addUrl:'http://localhost:8848/user',
    modifyUrl:'http://localhost:8848/updateUser'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    
    if(options.uid==undefined){
      return;
    }
    that.setData({
      uid: options.uid,
    });

    wx.request({
      url: 'http://localhost:8848/byid',
      data: { uid: options.uid},
      method:'GET',
      success:function(res){
        console.log(res);
        var area=res.data;
        if(area==undefined){
          var text='获取数据失败';
          wx.showToast({
            title: text,
            icon:'',
            duration:3000
          });
        }else{
          that.setData({
            uname:area.uname,
            uemail:area.uemail,
            upassword:area.upassword
          })
        }
      }
    })
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
 *  表单功能
 */
  formSubmit:function(e){
 
    var that=this;
  
    var formData=e.detail.value; //获取表数据
    var url=that.data.addUrl;  //默认url
    if(that.data.uid!=undefined){
      formData.uid=that.data.uid;
      url = that.data.modifyUrl;
    }else{
      url = that.data.addUrl;
    }
    wx.request({
      url: url,
      data:JSON.stringify(formData),
      method:'POST',
      header:{
        'Content-Type':'application/json'
      },
      success:function(res){
        console.log(res);
        var result=res.statusCode;
        var toastText="操作成功";
        if(result!=200){
          toastText="操作失败！";
        }
        wx.showToast({
          title: toastText,
          icon:'',
          duration:3000
        });
        
        wx.redirectTo({
          url: '../list/list',
        })
        // if(that.data.areaId=undefined){
        //   wx.redirectTo({
        //     url: '../list/list',
        //   })
        // }
      }
    })
  }
})
