(function () {
    var URL;
    URL = ctx + "/ud/";
    window.UEDITOR_CONFIG = {

        //为编辑器实例添加一个路径，这个不能被注释
        UEDITOR_HOME_URL : URL

        //图片上传配置区
        ,imageUrl:URL+"jsp/imageUp.jsp"             //图片上传提交地址
        ,imagePath:URL + "jsp/"                     //图片修正地址，引用了fixedImagePath,如有特殊需求，可自行配置
       //,imageFieldName:"upfile"                   //图片数据的key,若此处修改，需要在后台对应文件修改对应参数
        //,compressSide:0                            //等比压缩的基准，确定maxImageSideLength参数的参照对象。0为按照最长边，1为按照宽度，2为按照高度
        //,maxImageSideLength:900                    //上传图片最大允许的边长，超过会自动等比缩放,不缩放就设置一个比较大的值，更多设置在image.html中

        //涂鸦图片配置区
        ,scrawlUrl:URL+"jsp/scrawlUp.jsp"           //涂鸦上传地址
        ,scrawlPath:URL+"jsp/"                            //图片修正地址，同imagePath

        //附件上传配置区
        ,fileUrl:URL+"jsp/fileUp.jsp"               //附件上传提交地址
        ,filePath:URL + "jsp/"                   //附件修正地址，同imagePath
        //,fileFieldName:"upfile"                    //附件提交的表单名，若此处修改，需要在后台对应文件修改对应参数

         //远程抓取配置区
        //,catchRemoteImageEnable:true               //是否开启远程图片抓取,默认开启
        ,catcherUrl:URL +"jsp/getRemoteImage.jsp"   //处理远程图片抓取的地址
        ,catcherPath:URL + "jsp/"                  //图片修正地址，同imagePath
        //,catchFieldName:"upfile"                   //提交到后台远程图片uri合集，若此处修改，需要在后台对应文件修改对应参数
        //,separater:'ue_separate_ue'               //提交至后台的远程图片地址字符串分隔符
        //,localDomain:[]                            //本地顶级域名，当开启远程图片抓取时，除此之外的所有其它域名下的图片都将被抓取到本地,默认不抓取127.0.0.1和localhost

        //图片在线管理配置区
        ,imageManagerUrl:URL + "jsp/imageManager.jsp"       //图片在线管理的处理地址
        ,imageManagerPath:URL + "jsp/"                                    //图片修正地址，同imagePath

        //屏幕截图配置区
        ,snapscreenHost: '127.0.0.1'                                  //屏幕截图的server端文件所在的网站地址或者ip，请不要加http://
        ,snapscreenServerUrl: URL +"jsp/imageUp.jsp" //屏幕截图的server端保存程序，UEditor的范例代码为“URL +"server/upload/jsp/snapImgUp.jsp"”
        ,snapscreenPath: URL + "jsp/"
        //,snapscreenServerPort: 80                                    //屏幕截图的server端端口
        //,snapscreenImgAlign: ''                                //截图的图片默认的排版方式

        //word转存配置区
        ,wordImageUrl:URL + "jsp/imageUp.jsp"             //word转存提交地址
        ,wordImagePath:URL + "jsp/"                       //
        //,wordImageFieldName:"upfile"                     //word转存表单名若此处修改，需要在后台对应文件修改对应参数

        //获取视频数据的地址
        ,getMovieUrl:URL+"jsp/getMovie.jsp"                   //视频数据获取地址

        //工具栏上的所有的功能按钮和下拉框，可以在new编辑器的实例时选择自己需要的从新定义
        ,toolbars:[
            ['fullscreen', 'source', '|', 'undo', 'redo', '|',
                'bold', 'italic', 'underline', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch','autotypeset','blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist','selectall', 'cleardoc', '|',
                'rowspacingtop', 'rowspacingbottom','lineheight','|',
                'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
                'directionalityltr', 'directionalityrtl', 'indent', '|',
                'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|','touppercase','tolowercase','|',
                'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright','imagecenter', '|',
                'insertimage', 'emotion','scrawl', 'insertvideo','music','attachment', 'map', 'gmap', 'insertframe','highlightcode','webapp','pagebreak','template','background', '|',
                'horizontal', 'date', 'time', 'spechars','snapscreen', 'wordimage', '|',
                'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', '|',
                'print', 'preview', 'searchreplace','help']
        ]
        //当鼠标放在工具栏上时显示的tooltip提示,留空支持自动多语言配置，否则以配置值为准
        ,labelMap:{
            'anchor':'', 'undo':''
        }
        //webAppKey
        //百度应用的APIkey，每个站长必须首先去百度官网注册一个key后方能正常使用app功能
        ,webAppKey:""

    };
})();
