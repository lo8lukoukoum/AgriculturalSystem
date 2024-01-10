<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="javascript:searchHot('稻谷')">稻谷</a></li>
			<li><a href="javascript:searchHot('小麦')">小麦</a></li>
			<li><a href="javascript:searchHot('玉米')">玉米</a></li>
			<li><a href="javascript:searchHot('高粱')">高粱</a></li>
			<li><a href="javascript:searchHot('樱桃')">樱桃</a></li>
			<li><a href="javascript:searchHot('菠萝')">菠萝</a></li>
			<li><a href="javascript:searchHot('草莓')">草莓</a></li>
			<li><a href="javascript:searchHot('山药')">山药</a></li>
			<li><a href="javascript:searchHot('香菇')">香菇</a></li>
			<li><a href="javascript:searchHot('番茄')">番茄</a></li>
			<li><a href="javascript:searchHot('蜂蜜')">蜂蜜</a></li>
			<li><a href="javascript:searchHot('豆腐')">豆腐</a></li>
			<li><a href="javascript:searchHot('虾')">虾</a></li>
			<li class="last"><input type="text" id="selectname" value="${search_words }" /><a href="javascript:selectname()" >&nbsp;&nbsp;搜索</a></li>
		</ul>
	</div>
</div>