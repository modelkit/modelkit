## 
###介绍
　　**ModelKit**是一个一键生成iOS和Android项目Model的自动化工具。生成的JSON-schema文件可以作为团队多人敏捷开发的媒介，节约服务器端、iOS端、Android端三方面的接口制定、交流和开发时间。
###工具特点
######1.快速生成Objective-C和Java的model对象，后续计划支持生成Swift语言。
######2.通过HTTP或HTTPS请求下来JSON接口，并转化为JSON-schema文件。
######3.自定义HTTP头部信息。
###帮助反馈
　　这个软件是业余时间开发的，有很多不足之处和Bug，遇到问题请在[这里反馈](https://github.com/modelkit/modelkit/issues)。

###项目目录结构说明
　　此为演示Demo，在实际应用中，iOS、android、document最好分属不同的版本库。

    /
    +-android      adnroid项目Demo
	+-api          模拟Server端API
	+-iOS          OC项目Demo
	+-document     JSON-schema文档

###使用说明
　　软件运行环境为OSX10.10以上，windows系统暂时不支持。

　　对使用者的要求：了解iOS或Android项目开发(至少会运行项目里面的Demo)，熟悉MVC、MMVM或MVP等软件构件模式(至少理解Model层的设计)，了解JSON、HTTP、svn、git等。
###详细说明
1.下载本库代码以及下载ModelKit --> [下载地址](https://modelkit.github.io)。

2.点击设置Preferences或 <code>⌘</code>+<code>,</code> ，打开以下界面

![Setting](http://modelkit.github.io/res/setting.png)

设置General里的文档路径为<code>YourPath/document</code>，设置iOS的输出路径为<code>YourPath/iOS/Demo/ServerApi</code>，设置Android的输出路径为<code>YourPath/android/app/src/main/java/com/afantree/model</code>。

3.运行Product-->Run 或 <code>⌘</code>+<code>R</code>,打开预览界面，预览Model类的生成，预览类型可以在设置里面设置。

4.再次点击运行Product-->Run 或 <code>⌘</code>+<code>R</code>，生成项目代码。你可以安心的切换的项目中写代码了。

5.结束了，谢谢使用。相信此时的你对本软件有了大致的了解。

###功能进阶
　　为了更加方便的开发，还增加了3个小功能。

1. 从别处复制一段正确的JSON数据，点击主界面的右侧的编辑界面，然后按<code>⌘</code>+<code>V</code>粘贴进去，会有神奇的效果出现，编辑起JSON-schema是不是嗖嗖的？

2. 在主界面运行Product-->Update，最好是<code>⌘</code>+<code>U</code>快捷键，进行document库的更新，更新命令在设置里面设置，还支持自定义命令。


3. 主界面左下角有 <code>load remote data</code> 按钮，点开出现如下界面

　　　![Setting](http://modelkit.github.io/res/gethttp.png)

　　　点击这个窗口，仿照功能1，直接往里面粘贴数据即可，不过这里支持http开头的URL，例如这样的 <code>https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%E5%93%88%E5%93%88</code>，或这是从Charles的的Request--> Form 中copy出来的这样子的结构(key和value之间有空格或\t，这个也可以自己在某个地方编辑)

　　<code>version_code  	3030004</code>

　　<code>version_name	 3.3.0.4</code>

　　<code>channel   	1000e</code>

　　编辑好以后就开始点击获取数据，然后一个Json-schema就生成了，目前生成的里面没有注释(note)，建议补加一下。
　　
###葵花宝典
1. Json-schema中的URL地址，一般是把域名以及URL前面重复的去掉，只保留不同的部分，生成类的名字会有这个有关系。具体怎么关联见Demo。

