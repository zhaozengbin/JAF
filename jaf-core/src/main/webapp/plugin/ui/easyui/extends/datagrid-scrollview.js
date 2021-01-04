<!DOCTYPE html>
<html lang='zh-CN'>
<head>
<meta charset='utf-8'>
<meta content='IE=edge' http-equiv='X-UA-Compatible'>
<meta content='代码托管,git,Git@OSC,开源,项目管理,版本控制,开源代码,代码分享,项目协作,开源项目托管,免费代码托管,Git代码托管,Git托管服务' name='Keywords'>
<meta content='中国源代码托管(Git@OSC)是开源中国社区团队推出的基于Git的快速的、免费的、稳定的在线代码托管平台,不限制私有库和公有库数量.' name='Description'>
<title>
jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js · scott / jeecg - 代码托管 - 开源中国社区
</title>
<link href="/assets/favicon-28020a6101d7a4058376a3e5927c64d5.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
<link href="/assets/application-dec0e76c308e43a07f4bb20d5164e84c.css" media="screen" rel="stylesheet" type="text/css" />
<link href="/assets/base-ed33b90381e1ca1ac2e26217abac030d.css" media="screen" rel="stylesheet" type="text/css" />
<script src="/assets/application-85ab4ac53498279a723bee2437f59886.js" type="text/javascript"></script>
<meta content="authenticity_token" name="csrf-param" />
<meta content="etFGcrK8eUjfE5vX8N98JZx+1x7Zm7pN3wfD3u3BTOc=" name="csrf-token" />
<script type="text/javascript">
//<![CDATA[
window.gon = {};gon.gravatar_url="http://www.gravatar.com/avatar/%{hash}?s=%{size}&d=mm";
//]]>
</script>
</head>

<body class='ui_basic project'>
<script>
  $(function() {
    GitLab.GfmAutoComplete.dataSource = "/jeecg/jeecg/autocomplete_sources"
    GitLab.GfmAutoComplete.Emoji.assetBase = '/assets/emoji'
    GitLab.GfmAutoComplete.setup();
  });
</script>

<header class='navbar navbar-static-top navbar-gitlab'>
<div class='navbar-inner'>
<div class='container'>
<ul class='nav'>
<div class='nav login-reg'>
<a href="/login" class="btn-success btn">登录</a>
<a href="/signup" class="btn">注册</a>
</div>
</ul>
<style>
  .navbar-inner .container .nav.login-reg{
    margin-top:2px;
  }
</style>

<div class='app_logo'>
<a href="/"><h1>Git @ OSC</h1>
</a></div>
<ul class='nav' id='site-nav' style='float: left;'>
<li>
<a href="/explore">发现</a>
</li>
<li>
<a href="/oschina/git-osc/wikis/Home">帮助</a>
</li>
<li>
<a href="/oschina/git-osc/issues">建议</a>
</li>
<li>
<div class='search'>
<form accept-charset="UTF-8" action="/search" class="navbar-form pull-left" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
<input class="search-input header-search" id="search" name="search" placeholder="搜索" type="text" />
<input id="group_id" name="group_id" type="hidden" />
<input id="project_id" name="project_id" type="hidden" value="83820" />
</form>

</div>

</li>
</ul>

</div>
</div>
</header>

<div class='down-notify container'>
<div class='alert alert-danger' style='margin-bottom:5px;'>
<p class='text-center' style='margin-bottom:0px;'>
建议使用HTTPS方式管理您的项目，而不是SSH，这可能导致速度较慢。
</p>
</div>
</div>
<div class='flash-container'>
</div>

<!--[if lt IE 9]>
<div class='ie-warn alert alert-block'>
<a class="close" data-dismiss="alert">x</a>
<h4>Git @ OSC 温馨提示：</h4>
<p>
本站不支持 IE 8 及以下版本浏览器。
为了获得更好的浏览体验，我们强烈建议您
<a href="http://browsehappy.com" target="_blank">升级</a>
到最新版本的IE浏览器，或者使用较新版本的 Google Chrome、Firefox、Safari 等。
如果您使用的是 IE 9 或以上版本，请关闭“兼容性视图”。
</p>
</div>
<![endif]-->

<div class='container'>
<div class='title-actions-bar'>
<ul class='actions'>
<li class='watch-container'>
<a href="/login" class="button watch" title="登录以 Watch 这个项目"><span class='mini-icon git-icon-star'></span>
Watch
</a><a href="/jeecg/jeecg/watchers" class="social-count">18</a>
</li>
<li class='star-container'>
<a href="/login" class="button star" title="登录以 Star 这个项目"><span class='mini-icon git-icon-star'></span>
Star
</a><a href="/jeecg/jeecg/stargazers" class="social-count">19</a>
</li>
<li class='fork-container'>
<a href="/jeecg/jeecg/fork" class="button fork" data-confirm="Fork 将会复制此项目代码到您的空间中，是否继续？" data-method="post" rel="nofollow"><span class='mini-icon git-icon-branch-create'></span>
Fork
</a><a href="/jeecg/jeecg/members" class="social-count">20</a>
</li>
</ul>
<h1 class='entry-title'>
<div class='git-icon-pro large-icon pull-left' style='margin-left:-30px;margin-top:3px;'></div>
<div class='pro-title'>
<span class="project-title" style="line-height: 25px"><a href="/jeecg" class="author">scott</a> / <a href="/jeecg/jeecg" class="repository" style="padding-bottom: 0px">jeecg</a><div class='project-lang'>
<a href="/language/Java" class="language" target="_blank">Java</a>
</div>
</span>
<a href="/repositories/featured" title="此项目已被推荐"><span class='recomm-tag'>
荐
</span>
</a></div>
</h1>
</div>

<nav class='with_details_box main-nav'>
<ul>
<li class="active"><a href="/jeecg/jeecg">代码</a>
</li><li class=""><a href="/jeecg/jeecg/graph/master">项目网络</a>
</li><li class=""><a href="/jeecg/jeecg/pulls">Pull Requests
<span class='count merge_counter'>0</span>
</a></li><li class=""><a href="/jeecg/jeecg/issues">Issues
<span class='count issue_counter'>1</span>
</a></li><li class=""><a href="/jeecg/jeecg/wikis/home">Wiki</a>
</li><li class=""><a href="/jeecg/jeecg/attach_files">附件
<span class='count'>3</span>
</a></li></ul>

</nav>
<div class='content'><ul class='nav nav-tabs code-nav'>
<li><form accept-charset="UTF-8" action="/jeecg/jeecg/refs/switch" class="project-refs-form chzn-small" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
<select class="project-refs-select chosen" id="ref" name="ref"><optgroup label="Branch"><option value="master" selected="selected">master</option></optgroup><optgroup label="Tag"></optgroup></select>
<input id="destination" name="destination" type="hidden" value="tree" />
<input id="path" name="path" type="hidden" value="jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js" />
</form>

</li>
<li class="active"><a href="/jeecg/jeecg">文件</a>
</li><li class=""><a href="/jeecg/jeecg/commits/master">历史</a>
</li><li class=""><a href="/jeecg/jeecg/branches/recent">分支
<span class='badge'>1</span>
</a></li><li class=""><a href="/jeecg/jeecg/tags">标签
<span class='badge'>0</span>
</a></li><li class=""><a href="/jeecg/jeecg/repository/stats">统计
</a></li></ul>

<div class='tree-holder' id='tree-holder'>
<a href="/jeecg/jeecg/commits/master/jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js" class="commits-link"><i class='icon-time'></i>
历史
</a><ul class='breadcrumb'>
<li>
<a href="/jeecg/jeecg/tree/master" class="repo-name" data-direction="back">jeecg
</a></li>
/
<li>
<a href="#">..</a>
</li>
/
<li>
<a href="/jeecg/jeecg/tree/master/jeecg-framework/src/main/webapp/plug-in/easyui/extends" data-direction="back"><span class='cblue'>
extends
</span>
</a></li>
/
<li>
<strong>
datagrid-scrollview.js
</strong>
</li>
</ul>

<div class='tree-content-holder' id='tree-content-holder'>
<div class='recent-commit blob-commit'>
<a href="/jeecg" class="commit-author-link">zhangdaiscott</a>
提交于
<span class='timeago commit-date' title='2014-02-16 21:35:30 +0800'>
2014-02-16 21:35
</span>
<a href="/jeecg/jeecg/commit/f5cfb168f665832e02715d8420e3a7484807cab3">JEECG3.4.3发布版本</a>
</div>

<div class='file_holder'>
<div class='file_title'>
<i class='icon-file'></i>
<span class='file_name'>
datagrid-scrollview.js
<small>15.8 KB</small>
</span>
<span class='options'><div class='btn-group tree-btn-group' style='margin-top:4px;'>
<a href="/jeecg/jeecg/edit/master/jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js" class="btn btn-primary btn-small disabled has_tooltip" title="无编辑权限">编辑</a>
<a href="/jeecg/jeecg/raw/master/jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js" class="btn btn-primary btn-small">原始数据</a>
<a href="/jeecg/jeecg/blame/master/jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js" class="btn btn-primary btn-small">按行查看</a>
<a href="/jeecg/jeecg/commits/master/jeecg-framework/src/main/webapp/plug-in/easyui/extends/datagrid-scrollview.js" class="btn btn-primary btn-small">历史</a>
</div>
</span>
</div>
<div class='file_content code'>
<div class='lines white'>
<div class='line-numbers'><a href='#L1' id='L1' rel='#L#1'><i class='icon-link'></i>1</a><a href='#L2' id='L2' rel='#L#2'><i class='icon-link'></i>2</a><a href='#L3' id='L3' rel='#L#3'><i class='icon-link'></i>3</a><a href='#L4' id='L4' rel='#L#4'><i class='icon-link'></i>4</a><a href='#L5' id='L5' rel='#L#5'><i class='icon-link'></i>5</a><a href='#L6' id='L6' rel='#L#6'><i class='icon-link'></i>6</a><a href='#L7' id='L7' rel='#L#7'><i class='icon-link'></i>7</a><a href='#L8' id='L8' rel='#L#8'><i class='icon-link'></i>8</a><a href='#L9' id='L9' rel='#L#9'><i class='icon-link'></i>9</a><a href='#L10' id='L10' rel='#L#10'><i class='icon-link'></i>10</a><a href='#L11' id='L11' rel='#L#11'><i class='icon-link'></i>11</a><a href='#L12' id='L12' rel='#L#12'><i class='icon-link'></i>12</a><a href='#L13' id='L13' rel='#L#13'><i class='icon-link'></i>13</a><a href='#L14' id='L14' rel='#L#14'><i class='icon-link'></i>14</a><a href='#L15' id='L15' rel='#L#15'><i class='icon-link'></i>15</a><a href='#L16' id='L16' rel='#L#16'><i class='icon-link'></i>16</a><a href='#L17' id='L17' rel='#L#17'><i class='icon-link'></i>17</a><a href='#L18' id='L18' rel='#L#18'><i class='icon-link'></i>18</a><a href='#L19' id='L19' rel='#L#19'><i class='icon-link'></i>19</a><a href='#L20' id='L20' rel='#L#20'><i class='icon-link'></i>20</a><a href='#L21' id='L21' rel='#L#21'><i class='icon-link'></i>21</a><a href='#L22' id='L22' rel='#L#22'><i class='icon-link'></i>22</a><a href='#L23' id='L23' rel='#L#23'><i class='icon-link'></i>23</a><a href='#L24' id='L24' rel='#L#24'><i class='icon-link'></i>24</a><a href='#L25' id='L25' rel='#L#25'><i class='icon-link'></i>25</a><a href='#L26' id='L26' rel='#L#26'><i class='icon-link'></i>26</a><a href='#L27' id='L27' rel='#L#27'><i class='icon-link'></i>27</a><a href='#L28' id='L28' rel='#L#28'><i class='icon-link'></i>28</a><a href='#L29' id='L29' rel='#L#29'><i class='icon-link'></i>29</a><a href='#L30' id='L30' rel='#L#30'><i class='icon-link'></i>30</a><a href='#L31' id='L31' rel='#L#31'><i class='icon-link'></i>31</a><a href='#L32' id='L32' rel='#L#32'><i class='icon-link'></i>32</a><a href='#L33' id='L33' rel='#L#33'><i class='icon-link'></i>33</a><a href='#L34' id='L34' rel='#L#34'><i class='icon-link'></i>34</a><a href='#L35' id='L35' rel='#L#35'><i class='icon-link'></i>35</a><a href='#L36' id='L36' rel='#L#36'><i class='icon-link'></i>36</a><a href='#L37' id='L37' rel='#L#37'><i class='icon-link'></i>37</a><a href='#L38' id='L38' rel='#L#38'><i class='icon-link'></i>38</a><a href='#L39' id='L39' rel='#L#39'><i class='icon-link'></i>39</a><a href='#L40' id='L40' rel='#L#40'><i class='icon-link'></i>40</a><a href='#L41' id='L41' rel='#L#41'><i class='icon-link'></i>41</a><a href='#L42' id='L42' rel='#L#42'><i class='icon-link'></i>42</a><a href='#L43' id='L43' rel='#L#43'><i class='icon-link'></i>43</a><a href='#L44' id='L44' rel='#L#44'><i class='icon-link'></i>44</a><a href='#L45' id='L45' rel='#L#45'><i class='icon-link'></i>45</a><a href='#L46' id='L46' rel='#L#46'><i class='icon-link'></i>46</a><a href='#L47' id='L47' rel='#L#47'><i class='icon-link'></i>47</a><a href='#L48' id='L48' rel='#L#48'><i class='icon-link'></i>48</a><a href='#L49' id='L49' rel='#L#49'><i class='icon-link'></i>49</a><a href='#L50' id='L50' rel='#L#50'><i class='icon-link'></i>50</a><a href='#L51' id='L51' rel='#L#51'><i class='icon-link'></i>51</a><a href='#L52' id='L52' rel='#L#52'><i class='icon-link'></i>52</a><a href='#L53' id='L53' rel='#L#53'><i class='icon-link'></i>53</a><a href='#L54' id='L54' rel='#L#54'><i class='icon-link'></i>54</a><a href='#L55' id='L55' rel='#L#55'><i class='icon-link'></i>55</a><a href='#L56' id='L56' rel='#L#56'><i class='icon-link'></i>56</a><a href='#L57' id='L57' rel='#L#57'><i class='icon-link'></i>57</a><a href='#L58' id='L58' rel='#L#58'><i class='icon-link'></i>58</a><a href='#L59' id='L59' rel='#L#59'><i class='icon-link'></i>59</a><a href='#L60' id='L60' rel='#L#60'><i class='icon-link'></i>60</a><a href='#L61' id='L61' rel='#L#61'><i class='icon-link'></i>61</a><a href='#L62' id='L62' rel='#L#62'><i class='icon-link'></i>62</a><a href='#L63' id='L63' rel='#L#63'><i class='icon-link'></i>63</a><a href='#L64' id='L64' rel='#L#64'><i class='icon-link'></i>64</a><a href='#L65' id='L65' rel='#L#65'><i class='icon-link'></i>65</a><a href='#L66' id='L66' rel='#L#66'><i class='icon-link'></i>66</a><a href='#L67' id='L67' rel='#L#67'><i class='icon-link'></i>67</a><a href='#L68' id='L68' rel='#L#68'><i class='icon-link'></i>68</a><a href='#L69' id='L69' rel='#L#69'><i class='icon-link'></i>69</a><a href='#L70' id='L70' rel='#L#70'><i class='icon-link'></i>70</a><a href='#L71' id='L71' rel='#L#71'><i class='icon-link'></i>71</a><a href='#L72' id='L72' rel='#L#72'><i class='icon-link'></i>72</a><a href='#L73' id='L73' rel='#L#73'><i class='icon-link'></i>73</a><a href='#L74' id='L74' rel='#L#74'><i class='icon-link'></i>74</a><a href='#L75' id='L75' rel='#L#75'><i class='icon-link'></i>75</a><a href='#L76' id='L76' rel='#L#76'><i class='icon-link'></i>76</a><a href='#L77' id='L77' rel='#L#77'><i class='icon-link'></i>77</a><a href='#L78' id='L78' rel='#L#78'><i class='icon-link'></i>78</a><a href='#L79' id='L79' rel='#L#79'><i class='icon-link'></i>79</a><a href='#L80' id='L80' rel='#L#80'><i class='icon-link'></i>80</a><a href='#L81' id='L81' rel='#L#81'><i class='icon-link'></i>81</a><a href='#L82' id='L82' rel='#L#82'><i class='icon-link'></i>82</a><a href='#L83' id='L83' rel='#L#83'><i class='icon-link'></i>83</a><a href='#L84' id='L84' rel='#L#84'><i class='icon-link'></i>84</a><a href='#L85' id='L85' rel='#L#85'><i class='icon-link'></i>85</a><a href='#L86' id='L86' rel='#L#86'><i class='icon-link'></i>86</a><a href='#L87' id='L87' rel='#L#87'><i class='icon-link'></i>87</a><a href='#L88' id='L88' rel='#L#88'><i class='icon-link'></i>88</a><a href='#L89' id='L89' rel='#L#89'><i class='icon-link'></i>89</a><a href='#L90' id='L90' rel='#L#90'><i class='icon-link'></i>90</a><a href='#L91' id='L91' rel='#L#91'><i class='icon-link'></i>91</a><a href='#L92' id='L92' rel='#L#92'><i class='icon-link'></i>92</a><a href='#L93' id='L93' rel='#L#93'><i class='icon-link'></i>93</a><a href='#L94' id='L94' rel='#L#94'><i class='icon-link'></i>94</a><a href='#L95' id='L95' rel='#L#95'><i class='icon-link'></i>95</a><a href='#L96' id='L96' rel='#L#96'><i class='icon-link'></i>96</a><a href='#L97' id='L97' rel='#L#97'><i class='icon-link'></i>97</a><a href='#L98' id='L98' rel='#L#98'><i class='icon-link'></i>98</a><a href='#L99' id='L99' rel='#L#99'><i class='icon-link'></i>99</a><a href='#L100' id='L100' rel='#L#100'><i class='icon-link'></i>100</a><a href='#L101' id='L101' rel='#L#101'><i class='icon-link'></i>101</a><a href='#L102' id='L102' rel='#L#102'><i class='icon-link'></i>102</a><a href='#L103' id='L103' rel='#L#103'><i class='icon-link'></i>103</a><a href='#L104' id='L104' rel='#L#104'><i class='icon-link'></i>104</a><a href='#L105' id='L105' rel='#L#105'><i class='icon-link'></i>105</a><a href='#L106' id='L106' rel='#L#106'><i class='icon-link'></i>106</a><a href='#L107' id='L107' rel='#L#107'><i class='icon-link'></i>107</a><a href='#L108' id='L108' rel='#L#108'><i class='icon-link'></i>108</a><a href='#L109' id='L109' rel='#L#109'><i class='icon-link'></i>109</a><a href='#L110' id='L110' rel='#L#110'><i class='icon-link'></i>110</a><a href='#L111' id='L111' rel='#L#111'><i class='icon-link'></i>111</a><a href='#L112' id='L112' rel='#L#112'><i class='icon-link'></i>112</a><a href='#L113' id='L113' rel='#L#113'><i class='icon-link'></i>113</a><a href='#L114' id='L114' rel='#L#114'><i class='icon-link'></i>114</a><a href='#L115' id='L115' rel='#L#115'><i class='icon-link'></i>115</a><a href='#L116' id='L116' rel='#L#116'><i class='icon-link'></i>116</a><a href='#L117' id='L117' rel='#L#117'><i class='icon-link'></i>117</a><a href='#L118' id='L118' rel='#L#118'><i class='icon-link'></i>118</a><a href='#L119' id='L119' rel='#L#119'><i class='icon-link'></i>119</a><a href='#L120' id='L120' rel='#L#120'><i class='icon-link'></i>120</a><a href='#L121' id='L121' rel='#L#121'><i class='icon-link'></i>121</a><a href='#L122' id='L122' rel='#L#122'><i class='icon-link'></i>122</a><a href='#L123' id='L123' rel='#L#123'><i class='icon-link'></i>123</a><a href='#L124' id='L124' rel='#L#124'><i class='icon-link'></i>124</a><a href='#L125' id='L125' rel='#L#125'><i class='icon-link'></i>125</a><a href='#L126' id='L126' rel='#L#126'><i class='icon-link'></i>126</a><a href='#L127' id='L127' rel='#L#127'><i class='icon-link'></i>127</a><a href='#L128' id='L128' rel='#L#128'><i class='icon-link'></i>128</a><a href='#L129' id='L129' rel='#L#129'><i class='icon-link'></i>129</a><a href='#L130' id='L130' rel='#L#130'><i class='icon-link'></i>130</a><a href='#L131' id='L131' rel='#L#131'><i class='icon-link'></i>131</a><a href='#L132' id='L132' rel='#L#132'><i class='icon-link'></i>132</a><a href='#L133' id='L133' rel='#L#133'><i class='icon-link'></i>133</a><a href='#L134' id='L134' rel='#L#134'><i class='icon-link'></i>134</a><a href='#L135' id='L135' rel='#L#135'><i class='icon-link'></i>135</a><a href='#L136' id='L136' rel='#L#136'><i class='icon-link'></i>136</a><a href='#L137' id='L137' rel='#L#137'><i class='icon-link'></i>137</a><a href='#L138' id='L138' rel='#L#138'><i class='icon-link'></i>138</a><a href='#L139' id='L139' rel='#L#139'><i class='icon-link'></i>139</a><a href='#L140' id='L140' rel='#L#140'><i class='icon-link'></i>140</a><a href='#L141' id='L141' rel='#L#141'><i class='icon-link'></i>141</a><a href='#L142' id='L142' rel='#L#142'><i class='icon-link'></i>142</a><a href='#L143' id='L143' rel='#L#143'><i class='icon-link'></i>143</a><a href='#L144' id='L144' rel='#L#144'><i class='icon-link'></i>144</a><a href='#L145' id='L145' rel='#L#145'><i class='icon-link'></i>145</a><a href='#L146' id='L146' rel='#L#146'><i class='icon-link'></i>146</a><a href='#L147' id='L147' rel='#L#147'><i class='icon-link'></i>147</a><a href='#L148' id='L148' rel='#L#148'><i class='icon-link'></i>148</a><a href='#L149' id='L149' rel='#L#149'><i class='icon-link'></i>149</a><a href='#L150' id='L150' rel='#L#150'><i class='icon-link'></i>150</a><a href='#L151' id='L151' rel='#L#151'><i class='icon-link'></i>151</a><a href='#L152' id='L152' rel='#L#152'><i class='icon-link'></i>152</a><a href='#L153' id='L153' rel='#L#153'><i class='icon-link'></i>153</a><a href='#L154' id='L154' rel='#L#154'><i class='icon-link'></i>154</a><a href='#L155' id='L155' rel='#L#155'><i class='icon-link'></i>155</a><a href='#L156' id='L156' rel='#L#156'><i class='icon-link'></i>156</a><a href='#L157' id='L157' rel='#L#157'><i class='icon-link'></i>157</a><a href='#L158' id='L158' rel='#L#158'><i class='icon-link'></i>158</a><a href='#L159' id='L159' rel='#L#159'><i class='icon-link'></i>159</a><a href='#L160' id='L160' rel='#L#160'><i class='icon-link'></i>160</a><a href='#L161' id='L161' rel='#L#161'><i class='icon-link'></i>161</a><a href='#L162' id='L162' rel='#L#162'><i class='icon-link'></i>162</a><a href='#L163' id='L163' rel='#L#163'><i class='icon-link'></i>163</a><a href='#L164' id='L164' rel='#L#164'><i class='icon-link'></i>164</a><a href='#L165' id='L165' rel='#L#165'><i class='icon-link'></i>165</a><a href='#L166' id='L166' rel='#L#166'><i class='icon-link'></i>166</a><a href='#L167' id='L167' rel='#L#167'><i class='icon-link'></i>167</a><a href='#L168' id='L168' rel='#L#168'><i class='icon-link'></i>168</a><a href='#L169' id='L169' rel='#L#169'><i class='icon-link'></i>169</a><a href='#L170' id='L170' rel='#L#170'><i class='icon-link'></i>170</a><a href='#L171' id='L171' rel='#L#171'><i class='icon-link'></i>171</a><a href='#L172' id='L172' rel='#L#172'><i class='icon-link'></i>172</a><a href='#L173' id='L173' rel='#L#173'><i class='icon-link'></i>173</a><a href='#L174' id='L174' rel='#L#174'><i class='icon-link'></i>174</a><a href='#L175' id='L175' rel='#L#175'><i class='icon-link'></i>175</a><a href='#L176' id='L176' rel='#L#176'><i class='icon-link'></i>176</a><a href='#L177' id='L177' rel='#L#177'><i class='icon-link'></i>177</a><a href='#L178' id='L178' rel='#L#178'><i class='icon-link'></i>178</a><a href='#L179' id='L179' rel='#L#179'><i class='icon-link'></i>179</a><a href='#L180' id='L180' rel='#L#180'><i class='icon-link'></i>180</a><a href='#L181' id='L181' rel='#L#181'><i class='icon-link'></i>181</a><a href='#L182' id='L182' rel='#L#182'><i class='icon-link'></i>182</a><a href='#L183' id='L183' rel='#L#183'><i class='icon-link'></i>183</a><a href='#L184' id='L184' rel='#L#184'><i class='icon-link'></i>184</a><a href='#L185' id='L185' rel='#L#185'><i class='icon-link'></i>185</a><a href='#L186' id='L186' rel='#L#186'><i class='icon-link'></i>186</a><a href='#L187' id='L187' rel='#L#187'><i class='icon-link'></i>187</a><a href='#L188' id='L188' rel='#L#188'><i class='icon-link'></i>188</a><a href='#L189' id='L189' rel='#L#189'><i class='icon-link'></i>189</a><a href='#L190' id='L190' rel='#L#190'><i class='icon-link'></i>190</a><a href='#L191' id='L191' rel='#L#191'><i class='icon-link'></i>191</a><a href='#L192' id='L192' rel='#L#192'><i class='icon-link'></i>192</a><a href='#L193' id='L193' rel='#L#193'><i class='icon-link'></i>193</a><a href='#L194' id='L194' rel='#L#194'><i class='icon-link'></i>194</a><a href='#L195' id='L195' rel='#L#195'><i class='icon-link'></i>195</a><a href='#L196' id='L196' rel='#L#196'><i class='icon-link'></i>196</a><a href='#L197' id='L197' rel='#L#197'><i class='icon-link'></i>197</a><a href='#L198' id='L198' rel='#L#198'><i class='icon-link'></i>198</a><a href='#L199' id='L199' rel='#L#199'><i class='icon-link'></i>199</a><a href='#L200' id='L200' rel='#L#200'><i class='icon-link'></i>200</a><a href='#L201' id='L201' rel='#L#201'><i class='icon-link'></i>201</a><a href='#L202' id='L202' rel='#L#202'><i class='icon-link'></i>202</a><a href='#L203' id='L203' rel='#L#203'><i class='icon-link'></i>203</a><a href='#L204' id='L204' rel='#L#204'><i class='icon-link'></i>204</a><a href='#L205' id='L205' rel='#L#205'><i class='icon-link'></i>205</a><a href='#L206' id='L206' rel='#L#206'><i class='icon-link'></i>206</a><a href='#L207' id='L207' rel='#L#207'><i class='icon-link'></i>207</a><a href='#L208' id='L208' rel='#L#208'><i class='icon-link'></i>208</a><a href='#L209' id='L209' rel='#L#209'><i class='icon-link'></i>209</a><a href='#L210' id='L210' rel='#L#210'><i class='icon-link'></i>210</a><a href='#L211' id='L211' rel='#L#211'><i class='icon-link'></i>211</a><a href='#L212' id='L212' rel='#L#212'><i class='icon-link'></i>212</a><a href='#L213' id='L213' rel='#L#213'><i class='icon-link'></i>213</a><a href='#L214' id='L214' rel='#L#214'><i class='icon-link'></i>214</a><a href='#L215' id='L215' rel='#L#215'><i class='icon-link'></i>215</a><a href='#L216' id='L216' rel='#L#216'><i class='icon-link'></i>216</a><a href='#L217' id='L217' rel='#L#217'><i class='icon-link'></i>217</a><a href='#L218' id='L218' rel='#L#218'><i class='icon-link'></i>218</a><a href='#L219' id='L219' rel='#L#219'><i class='icon-link'></i>219</a><a href='#L220' id='L220' rel='#L#220'><i class='icon-link'></i>220</a><a href='#L221' id='L221' rel='#L#221'><i class='icon-link'></i>221</a><a href='#L222' id='L222' rel='#L#222'><i class='icon-link'></i>222</a><a href='#L223' id='L223' rel='#L#223'><i class='icon-link'></i>223</a><a href='#L224' id='L224' rel='#L#224'><i class='icon-link'></i>224</a><a href='#L225' id='L225' rel='#L#225'><i class='icon-link'></i>225</a><a href='#L226' id='L226' rel='#L#226'><i class='icon-link'></i>226</a><a href='#L227' id='L227' rel='#L#227'><i class='icon-link'></i>227</a><a href='#L228' id='L228' rel='#L#228'><i class='icon-link'></i>228</a><a href='#L229' id='L229' rel='#L#229'><i class='icon-link'></i>229</a><a href='#L230' id='L230' rel='#L#230'><i class='icon-link'></i>230</a><a href='#L231' id='L231' rel='#L#231'><i class='icon-link'></i>231</a><a href='#L232' id='L232' rel='#L#232'><i class='icon-link'></i>232</a><a href='#L233' id='L233' rel='#L#233'><i class='icon-link'></i>233</a><a href='#L234' id='L234' rel='#L#234'><i class='icon-link'></i>234</a><a href='#L235' id='L235' rel='#L#235'><i class='icon-link'></i>235</a><a href='#L236' id='L236' rel='#L#236'><i class='icon-link'></i>236</a><a href='#L237' id='L237' rel='#L#237'><i class='icon-link'></i>237</a><a href='#L238' id='L238' rel='#L#238'><i class='icon-link'></i>238</a><a href='#L239' id='L239' rel='#L#239'><i class='icon-link'></i>239</a><a href='#L240' id='L240' rel='#L#240'><i class='icon-link'></i>240</a><a href='#L241' id='L241' rel='#L#241'><i class='icon-link'></i>241</a><a href='#L242' id='L242' rel='#L#242'><i class='icon-link'></i>242</a><a href='#L243' id='L243' rel='#L#243'><i class='icon-link'></i>243</a><a href='#L244' id='L244' rel='#L#244'><i class='icon-link'></i>244</a><a href='#L245' id='L245' rel='#L#245'><i class='icon-link'></i>245</a><a href='#L246' id='L246' rel='#L#246'><i class='icon-link'></i>246</a><a href='#L247' id='L247' rel='#L#247'><i class='icon-link'></i>247</a><a href='#L248' id='L248' rel='#L#248'><i class='icon-link'></i>248</a><a href='#L249' id='L249' rel='#L#249'><i class='icon-link'></i>249</a><a href='#L250' id='L250' rel='#L#250'><i class='icon-link'></i>250</a><a href='#L251' id='L251' rel='#L#251'><i class='icon-link'></i>251</a><a href='#L252' id='L252' rel='#L#252'><i class='icon-link'></i>252</a><a href='#L253' id='L253' rel='#L#253'><i class='icon-link'></i>253</a><a href='#L254' id='L254' rel='#L#254'><i class='icon-link'></i>254</a><a href='#L255' id='L255' rel='#L#255'><i class='icon-link'></i>255</a><a href='#L256' id='L256' rel='#L#256'><i class='icon-link'></i>256</a><a href='#L257' id='L257' rel='#L#257'><i class='icon-link'></i>257</a><a href='#L258' id='L258' rel='#L#258'><i class='icon-link'></i>258</a><a href='#L259' id='L259' rel='#L#259'><i class='icon-link'></i>259</a><a href='#L260' id='L260' rel='#L#260'><i class='icon-link'></i>260</a><a href='#L261' id='L261' rel='#L#261'><i class='icon-link'></i>261</a><a href='#L262' id='L262' rel='#L#262'><i class='icon-link'></i>262</a><a href='#L263' id='L263' rel='#L#263'><i class='icon-link'></i>263</a><a href='#L264' id='L264' rel='#L#264'><i class='icon-link'></i>264</a><a href='#L265' id='L265' rel='#L#265'><i class='icon-link'></i>265</a><a href='#L266' id='L266' rel='#L#266'><i class='icon-link'></i>266</a><a href='#L267' id='L267' rel='#L#267'><i class='icon-link'></i>267</a><a href='#L268' id='L268' rel='#L#268'><i class='icon-link'></i>268</a><a href='#L269' id='L269' rel='#L#269'><i class='icon-link'></i>269</a><a href='#L270' id='L270' rel='#L#270'><i class='icon-link'></i>270</a><a href='#L271' id='L271' rel='#L#271'><i class='icon-link'></i>271</a><a href='#L272' id='L272' rel='#L#272'><i class='icon-link'></i>272</a><a href='#L273' id='L273' rel='#L#273'><i class='icon-link'></i>273</a><a href='#L274' id='L274' rel='#L#274'><i class='icon-link'></i>274</a><a href='#L275' id='L275' rel='#L#275'><i class='icon-link'></i>275</a><a href='#L276' id='L276' rel='#L#276'><i class='icon-link'></i>276</a><a href='#L277' id='L277' rel='#L#277'><i class='icon-link'></i>277</a><a href='#L278' id='L278' rel='#L#278'><i class='icon-link'></i>278</a><a href='#L279' id='L279' rel='#L#279'><i class='icon-link'></i>279</a><a href='#L280' id='L280' rel='#L#280'><i class='icon-link'></i>280</a><a href='#L281' id='L281' rel='#L#281'><i class='icon-link'></i>281</a><a href='#L282' id='L282' rel='#L#282'><i class='icon-link'></i>282</a><a href='#L283' id='L283' rel='#L#283'><i class='icon-link'></i>283</a><a href='#L284' id='L284' rel='#L#284'><i class='icon-link'></i>284</a><a href='#L285' id='L285' rel='#L#285'><i class='icon-link'></i>285</a><a href='#L286' id='L286' rel='#L#286'><i class='icon-link'></i>286</a><a href='#L287' id='L287' rel='#L#287'><i class='icon-link'></i>287</a><a href='#L288' id='L288' rel='#L#288'><i class='icon-link'></i>288</a><a href='#L289' id='L289' rel='#L#289'><i class='icon-link'></i>289</a><a href='#L290' id='L290' rel='#L#290'><i class='icon-link'></i>290</a><a href='#L291' id='L291' rel='#L#291'><i class='icon-link'></i>291</a><a href='#L292' id='L292' rel='#L#292'><i class='icon-link'></i>292</a><a href='#L293' id='L293' rel='#L#293'><i class='icon-link'></i>293</a><a href='#L294' id='L294' rel='#L#294'><i class='icon-link'></i>294</a><a href='#L295' id='L295' rel='#L#295'><i class='icon-link'></i>295</a><a href='#L296' id='L296' rel='#L#296'><i class='icon-link'></i>296</a><a href='#L297' id='L297' rel='#L#297'><i class='icon-link'></i>297</a><a href='#L298' id='L298' rel='#L#298'><i class='icon-link'></i>298</a><a href='#L299' id='L299' rel='#L#299'><i class='icon-link'></i>299</a><a href='#L300' id='L300' rel='#L#300'><i class='icon-link'></i>300</a><a href='#L301' id='L301' rel='#L#301'><i class='icon-link'></i>301</a><a href='#L302' id='L302' rel='#L#302'><i class='icon-link'></i>302</a><a href='#L303' id='L303' rel='#L#303'><i class='icon-link'></i>303</a><a href='#L304' id='L304' rel='#L#304'><i class='icon-link'></i>304</a><a href='#L305' id='L305' rel='#L#305'><i class='icon-link'></i>305</a><a href='#L306' id='L306' rel='#L#306'><i class='icon-link'></i>306</a><a href='#L307' id='L307' rel='#L#307'><i class='icon-link'></i>307</a><a href='#L308' id='L308' rel='#L#308'><i class='icon-link'></i>308</a><a href='#L309' id='L309' rel='#L#309'><i class='icon-link'></i>309</a><a href='#L310' id='L310' rel='#L#310'><i class='icon-link'></i>310</a><a href='#L311' id='L311' rel='#L#311'><i class='icon-link'></i>311</a><a href='#L312' id='L312' rel='#L#312'><i class='icon-link'></i>312</a><a href='#L313' id='L313' rel='#L#313'><i class='icon-link'></i>313</a><a href='#L314' id='L314' rel='#L#314'><i class='icon-link'></i>314</a><a href='#L315' id='L315' rel='#L#315'><i class='icon-link'></i>315</a><a href='#L316' id='L316' rel='#L#316'><i class='icon-link'></i>316</a><a href='#L317' id='L317' rel='#L#317'><i class='icon-link'></i>317</a><a href='#L318' id='L318' rel='#L#318'><i class='icon-link'></i>318</a><a href='#L319' id='L319' rel='#L#319'><i class='icon-link'></i>319</a><a href='#L320' id='L320' rel='#L#320'><i class='icon-link'></i>320</a><a href='#L321' id='L321' rel='#L#321'><i class='icon-link'></i>321</a><a href='#L322' id='L322' rel='#L#322'><i class='icon-link'></i>322</a><a href='#L323' id='L323' rel='#L#323'><i class='icon-link'></i>323</a><a href='#L324' id='L324' rel='#L#324'><i class='icon-link'></i>324</a><a href='#L325' id='L325' rel='#L#325'><i class='icon-link'></i>325</a><a href='#L326' id='L326' rel='#L#326'><i class='icon-link'></i>326</a><a href='#L327' id='L327' rel='#L#327'><i class='icon-link'></i>327</a><a href='#L328' id='L328' rel='#L#328'><i class='icon-link'></i>328</a><a href='#L329' id='L329' rel='#L#329'><i class='icon-link'></i>329</a><a href='#L330' id='L330' rel='#L#330'><i class='icon-link'></i>330</a><a href='#L331' id='L331' rel='#L#331'><i class='icon-link'></i>331</a><a href='#L332' id='L332' rel='#L#332'><i class='icon-link'></i>332</a><a href='#L333' id='L333' rel='#L#333'><i class='icon-link'></i>333</a><a href='#L334' id='L334' rel='#L#334'><i class='icon-link'></i>334</a><a href='#L335' id='L335' rel='#L#335'><i class='icon-link'></i>335</a><a href='#L336' id='L336' rel='#L#336'><i class='icon-link'></i>336</a><a href='#L337' id='L337' rel='#L#337'><i class='icon-link'></i>337</a><a href='#L338' id='L338' rel='#L#338'><i class='icon-link'></i>338</a><a href='#L339' id='L339' rel='#L#339'><i class='icon-link'></i>339</a><a href='#L340' id='L340' rel='#L#340'><i class='icon-link'></i>340</a><a href='#L341' id='L341' rel='#L#341'><i class='icon-link'></i>341</a><a href='#L342' id='L342' rel='#L#342'><i class='icon-link'></i>342</a><a href='#L343' id='L343' rel='#L#343'><i class='icon-link'></i>343</a><a href='#L344' id='L344' rel='#L#344'><i class='icon-link'></i>344</a><a href='#L345' id='L345' rel='#L#345'><i class='icon-link'></i>345</a><a href='#L346' id='L346' rel='#L#346'><i class='icon-link'></i>346</a><a href='#L347' id='L347' rel='#L#347'><i class='icon-link'></i>347</a><a href='#L348' id='L348' rel='#L#348'><i class='icon-link'></i>348</a><a href='#L349' id='L349' rel='#L#349'><i class='icon-link'></i>349</a><a href='#L350' id='L350' rel='#L#350'><i class='icon-link'></i>350</a><a href='#L351' id='L351' rel='#L#351'><i class='icon-link'></i>351</a><a href='#L352' id='L352' rel='#L#352'><i class='icon-link'></i>352</a><a href='#L353' id='L353' rel='#L#353'><i class='icon-link'></i>353</a><a href='#L354' id='L354' rel='#L#354'><i class='icon-link'></i>354</a><a href='#L355' id='L355' rel='#L#355'><i class='icon-link'></i>355</a><a href='#L356' id='L356' rel='#L#356'><i class='icon-link'></i>356</a><a href='#L357' id='L357' rel='#L#357'><i class='icon-link'></i>357</a><a href='#L358' id='L358' rel='#L#358'><i class='icon-link'></i>358</a><a href='#L359' id='L359' rel='#L#359'><i class='icon-link'></i>359</a><a href='#L360' id='L360' rel='#L#360'><i class='icon-link'></i>360</a><a href='#L361' id='L361' rel='#L#361'><i class='icon-link'></i>361</a><a href='#L362' id='L362' rel='#L#362'><i class='icon-link'></i>362</a><a href='#L363' id='L363' rel='#L#363'><i class='icon-link'></i>363</a><a href='#L364' id='L364' rel='#L#364'><i class='icon-link'></i>364</a><a href='#L365' id='L365' rel='#L#365'><i class='icon-link'></i>365</a><a href='#L366' id='L366' rel='#L#366'><i class='icon-link'></i>366</a><a href='#L367' id='L367' rel='#L#367'><i class='icon-link'></i>367</a><a href='#L368' id='L368' rel='#L#368'><i class='icon-link'></i>368</a><a href='#L369' id='L369' rel='#L#369'><i class='icon-link'></i>369</a><a href='#L370' id='L370' rel='#L#370'><i class='icon-link'></i>370</a><a href='#L371' id='L371' rel='#L#371'><i class='icon-link'></i>371</a><a href='#L372' id='L372' rel='#L#372'><i class='icon-link'></i>372</a><a href='#L373' id='L373' rel='#L#373'><i class='icon-link'></i>373</a><a href='#L374' id='L374' rel='#L#374'><i class='icon-link'></i>374</a><a href='#L375' id='L375' rel='#L#375'><i class='icon-link'></i>375</a><a href='#L376' id='L376' rel='#L#376'><i class='icon-link'></i>376</a><a href='#L377' id='L377' rel='#L#377'><i class='icon-link'></i>377</a><a href='#L378' id='L378' rel='#L#378'><i class='icon-link'></i>378</a><a href='#L379' id='L379' rel='#L#379'><i class='icon-link'></i>379</a><a href='#L380' id='L380' rel='#L#380'><i class='icon-link'></i>380</a><a href='#L381' id='L381' rel='#L#381'><i class='icon-link'></i>381</a><a href='#L382' id='L382' rel='#L#382'><i class='icon-link'></i>382</a><a href='#L383' id='L383' rel='#L#383'><i class='icon-link'></i>383</a><a href='#L384' id='L384' rel='#L#384'><i class='icon-link'></i>384</a><a href='#L385' id='L385' rel='#L#385'><i class='icon-link'></i>385</a><a href='#L386' id='L386' rel='#L#386'><i class='icon-link'></i>386</a><a href='#L387' id='L387' rel='#L#387'><i class='icon-link'></i>387</a><a href='#L388' id='L388' rel='#L#388'><i class='icon-link'></i>388</a><a href='#L389' id='L389' rel='#L#389'><i class='icon-link'></i>389</a><a href='#L390' id='L390' rel='#L#390'><i class='icon-link'></i>390</a><a href='#L391' id='L391' rel='#L#391'><i class='icon-link'></i>391</a><a href='#L392' id='L392' rel='#L#392'><i class='icon-link'></i>392</a><a href='#L393' id='L393' rel='#L#393'><i class='icon-link'></i>393</a><a href='#L394' id='L394' rel='#L#394'><i class='icon-link'></i>394</a><a href='#L395' id='L395' rel='#L#395'><i class='icon-link'></i>395</a><a href='#L396' id='L396' rel='#L#396'><i class='icon-link'></i>396</a><a href='#L397' id='L397' rel='#L#397'><i class='icon-link'></i>397</a><a href='#L398' id='L398' rel='#L#398'><i class='icon-link'></i>398</a><a href='#L399' id='L399' rel='#L#399'><i class='icon-link'></i>399</a><a href='#L400' id='L400' rel='#L#400'><i class='icon-link'></i>400</a><a href='#L401' id='L401' rel='#L#401'><i class='icon-link'></i>401</a><a href='#L402' id='L402' rel='#L#402'><i class='icon-link'></i>402</a><a href='#L403' id='L403' rel='#L#403'><i class='icon-link'></i>403</a><a href='#L404' id='L404' rel='#L#404'><i class='icon-link'></i>404</a><a href='#L405' id='L405' rel='#L#405'><i class='icon-link'></i>405</a><a href='#L406' id='L406' rel='#L#406'><i class='icon-link'></i>406</a><a href='#L407' id='L407' rel='#L#407'><i class='icon-link'></i>407</a><a href='#L408' id='L408' rel='#L#408'><i class='icon-link'></i>408</a><a href='#L409' id='L409' rel='#L#409'><i class='icon-link'></i>409</a><a href='#L410' id='L410' rel='#L#410'><i class='icon-link'></i>410</a><a href='#L411' id='L411' rel='#L#411'><i class='icon-link'></i>411</a><a href='#L412' id='L412' rel='#L#412'><i class='icon-link'></i>412</a><a href='#L413' id='L413' rel='#L#413'><i class='icon-link'></i>413</a><a href='#L414' id='L414' rel='#L#414'><i class='icon-link'></i>414</a><a href='#L415' id='L415' rel='#L#415'><i class='icon-link'></i>415</a><a href='#L416' id='L416' rel='#L#416'><i class='icon-link'></i>416</a><a href='#L417' id='L417' rel='#L#417'><i class='icon-link'></i>417</a><a href='#L418' id='L418' rel='#L#418'><i class='icon-link'></i>418</a><a href='#L419' id='L419' rel='#L#419'><i class='icon-link'></i>419</a><a href='#L420' id='L420' rel='#L#420'><i class='icon-link'></i>420</a><a href='#L421' id='L421' rel='#L#421'><i class='icon-link'></i>421</a><a href='#L422' id='L422' rel='#L#422'><i class='icon-link'></i>422</a><a href='#L423' id='L423' rel='#L#423'><i class='icon-link'></i>423</a><a href='#L424' id='L424' rel='#L#424'><i class='icon-link'></i>424</a><a href='#L425' id='L425' rel='#L#425'><i class='icon-link'></i>425</a><a href='#L426' id='L426' rel='#L#426'><i class='icon-link'></i>426</a><a href='#L427' id='L427' rel='#L#427'><i class='icon-link'></i>427</a><a href='#L428' id='L428' rel='#L#428'><i class='icon-link'></i>428</a><a href='#L429' id='L429' rel='#L#429'><i class='icon-link'></i>429</a><a href='#L430' id='L430' rel='#L#430'><i class='icon-link'></i>430</a><a href='#L431' id='L431' rel='#L#431'><i class='icon-link'></i>431</a><a href='#L432' id='L432' rel='#L#432'><i class='icon-link'></i>432</a><a href='#L433' id='L433' rel='#L#433'><i class='icon-link'></i>433</a><a href='#L434' id='L434' rel='#L#434'><i class='icon-link'></i>434</a><a href='#L435' id='L435' rel='#L#435'><i class='icon-link'></i>435</a><a href='#L436' id='L436' rel='#L#436'><i class='icon-link'></i>436</a><a href='#L437' id='L437' rel='#L#437'><i class='icon-link'></i>437</a><a href='#L438' id='L438' rel='#L#438'><i class='icon-link'></i>438</a><a href='#L439' id='L439' rel='#L#439'><i class='icon-link'></i>439</a><a href='#L440' id='L440' rel='#L#440'><i class='icon-link'></i>440</a><a href='#L441' id='L441' rel='#L#441'><i class='icon-link'></i>441</a><a href='#L442' id='L442' rel='#L#442'><i class='icon-link'></i>442</a><a href='#L443' id='L443' rel='#L#443'><i class='icon-link'></i>443</a><a href='#L444' id='L444' rel='#L#444'><i class='icon-link'></i>444</a><a href='#L445' id='L445' rel='#L#445'><i class='icon-link'></i>445</a><a href='#L446' id='L446' rel='#L#446'><i class='icon-link'></i>446</a><a href='#L447' id='L447' rel='#L#447'><i class='icon-link'></i>447</a><a href='#L448' id='L448' rel='#L#448'><i class='icon-link'></i>448</a><a href='#L449' id='L449' rel='#L#449'><i class='icon-link'></i>449</a><a href='#L450' id='L450' rel='#L#450'><i class='icon-link'></i>450</a><a href='#L451' id='L451' rel='#L#451'><i class='icon-link'></i>451</a><a href='#L452' id='L452' rel='#L#452'><i class='icon-link'></i>452</a><a href='#L453' id='L453' rel='#L#453'><i class='icon-link'></i>453</a><a href='#L454' id='L454' rel='#L#454'><i class='icon-link'></i>454</a><a href='#L455' id='L455' rel='#L#455'><i class='icon-link'></i>455</a><a href='#L456' id='L456' rel='#L#456'><i class='icon-link'></i>456</a><a href='#L457' id='L457' rel='#L#457'><i class='icon-link'></i>457</a><a href='#L458' id='L458' rel='#L#458'><i class='icon-link'></i>458</a><a href='#L459' id='L459' rel='#L#459'><i class='icon-link'></i>459</a><a href='#L460' id='L460' rel='#L#460'><i class='icon-link'></i>460</a><a href='#L461' id='L461' rel='#L#461'><i class='icon-link'></i>461</a><a href='#L462' id='L462' rel='#L#462'><i class='icon-link'></i>462</a><a href='#L463' id='L463' rel='#L#463'><i class='icon-link'></i>463</a><a href='#L464' id='L464' rel='#L#464'><i class='icon-link'></i>464</a><a href='#L465' id='L465' rel='#L#465'><i class='icon-link'></i>465</a><a href='#L466' id='L466' rel='#L#466'><i class='icon-link'></i>466</a><a href='#L467' id='L467' rel='#L#467'><i class='icon-link'></i>467</a><a href='#L468' id='L468' rel='#L#468'><i class='icon-link'></i>468</a><a href='#L469' id='L469' rel='#L#469'><i class='icon-link'></i>469</a><a href='#L470' id='L470' rel='#L#470'><i class='icon-link'></i>470</a><a href='#L471' id='L471' rel='#L#471'><i class='icon-link'></i>471</a><a href='#L472' id='L472' rel='#L#472'><i class='icon-link'></i>472</a><a href='#L473' id='L473' rel='#L#473'><i class='icon-link'></i>473</a><a href='#L474' id='L474' rel='#L#474'><i class='icon-link'></i>474</a><a href='#L475' id='L475' rel='#L#475'><i class='icon-link'></i>475</a><a href='#L476' id='L476' rel='#L#476'><i class='icon-link'></i>476</a><a href='#L477' id='L477' rel='#L#477'><i class='icon-link'></i>477</a><a href='#L478' id='L478' rel='#L#478'><i class='icon-link'></i>478</a><a href='#L479' id='L479' rel='#L#479'><i class='icon-link'></i>479</a><a href='#L480' id='L480' rel='#L#480'><i class='icon-link'></i>480</a><a href='#L481' id='L481' rel='#L#481'><i class='icon-link'></i>481</a><a href='#L482' id='L482' rel='#L#482'><i class='icon-link'></i>482</a><a href='#L483' id='L483' rel='#L#483'><i class='icon-link'></i>483</a><a href='#L484' id='L484' rel='#L#484'><i class='icon-link'></i>484</a><a href='#L485' id='L485' rel='#L#485'><i class='icon-link'></i>485</a><a href='#L486' id='L486' rel='#L#486'><i class='icon-link'></i>486</a><a href='#L487' id='L487' rel='#L#487'><i class='icon-link'></i>487</a><a href='#L488' id='L488' rel='#L#488'><i class='icon-link'></i>488</a><a href='#L489' id='L489' rel='#L#489'><i class='icon-link'></i>489</a><a href='#L490' id='L490' rel='#L#490'><i class='icon-link'></i>490</a><a href='#L491' id='L491' rel='#L#491'><i class='icon-link'></i>491</a><a href='#L492' id='L492' rel='#L#492'><i class='icon-link'></i>492</a><a href='#L493' id='L493' rel='#L#493'><i class='icon-link'></i>493</a><a href='#L494' id='L494' rel='#L#494'><i class='icon-link'></i>494</a><a href='#L495' id='L495' rel='#L#495'><i class='icon-link'></i>495</a><a href='#L496' id='L496' rel='#L#496'><i class='icon-link'></i>496</a><a href='#L497' id='L497' rel='#L#497'><i class='icon-link'></i>497</a><a href='#L498' id='L498' rel='#L#498'><i class='icon-link'></i>498</a><a href='#L499' id='L499' rel='#L#499'><i class='icon-link'></i>499</a><a href='#L500' id='L500' rel='#L#500'><i class='icon-link'></i>500</a><a href='#L501' id='L501' rel='#L#501'><i class='icon-link'></i>501</a><a href='#L502' id='L502' rel='#L#502'><i class='icon-link'></i>502</a><a href='#L503' id='L503' rel='#L#503'><i class='icon-link'></i>503</a><a href='#L504' id='L504' rel='#L#504'><i class='icon-link'></i>504</a><a href='#L505' id='L505' rel='#L#505'><i class='icon-link'></i>505</a><a href='#L506' id='L506' rel='#L#506'><i class='icon-link'></i>506</a><a href='#L507' id='L507' rel='#L#507'><i class='icon-link'></i>507</a><a href='#L508' id='L508' rel='#L#508'><i class='icon-link'></i>508</a><a href='#L509' id='L509' rel='#L#509'><i class='icon-link'></i>509</a><a href='#L510' id='L510' rel='#L#510'><i class='icon-link'></i>510</a><a href='#L511' id='L511' rel='#L#511'><i class='icon-link'></i>511</a><a href='#L512' id='L512' rel='#L#512'><i class='icon-link'></i>512</a><a href='#L513' id='L513' rel='#L#513'><i class='icon-link'></i>513</a><a href='#L514' id='L514' rel='#L#514'><i class='icon-link'></i>514</a><a href='#L515' id='L515' rel='#L#515'><i class='icon-link'></i>515</a><a href='#L516' id='L516' rel='#L#516'><i class='icon-link'></i>516</a><a href='#L517' id='L517' rel='#L#517'><i class='icon-link'></i>517</a><a href='#L518' id='L518' rel='#L#518'><i class='icon-link'></i>518</a><a href='#L519' id='L519' rel='#L#519'><i class='icon-link'></i>519</a><a href='#L520' id='L520' rel='#L#520'><i class='icon-link'></i>520</a><a href='#L521' id='L521' rel='#L#521'><i class='icon-link'></i>521</a><a href='#L522' id='L522' rel='#L#522'><i class='icon-link'></i>522</a><a href='#L523' id='L523' rel='#L#523'><i class='icon-link'></i>523</a><a href='#L524' id='L524' rel='#L#524'><i class='icon-link'></i>524</a><a href='#L525' id='L525' rel='#L#525'><i class='icon-link'></i>525</a><a href='#L526' id='L526' rel='#L#526'><i class='icon-link'></i>526</a><a href='#L527' id='L527' rel='#L#527'><i class='icon-link'></i>527</a><a href='#L528' id='L528' rel='#L#528'><i class='icon-link'></i>528</a><a href='#L529' id='L529' rel='#L#529'><i class='icon-link'></i>529</a><a href='#L530' id='L530' rel='#L#530'><i class='icon-link'></i>530</a><a href='#L531' id='L531' rel='#L#531'><i class='icon-link'></i>531</a><a href='#L532' id='L532' rel='#L#532'><i class='icon-link'></i>532</a><a href='#L533' id='L533' rel='#L#533'><i class='icon-link'></i>533</a></div><div class='highlight'><pre><div class='line' id='LC1'><span class="cm">/***
</div><div class='line' id='LC2'> * @author jueyue
</div><div class='line' id='LC3'> * @version1.0
</div><div class='line' id='LC4'> *虚拟布局，提供大数据量的布局方式，最好的方式是自己提供高度和宽度，默认高度25
</div><div class='line' id='LC5'> *特别是在有图片的情况下,请指定行高默认25px
</div><div class='line' id='LC6'> *如果修改高度 rowStyler 指定行高，不然不好对齐
</div><div class='line' id='LC7'> *一次加载数据多次渲染数据,所以ie下也不存在行数太多而不渲染失败的问题
</div><div class='line' id='LC8'> */</span>
</div><div class='line' id='LC9'><span class="kd">var</span> <span class="nx">scrollview</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">extend</span><span class="p">({},</span> <span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">datagrid</span><span class="p">.</span><span class="nx">defaults</span><span class="p">.</span><span class="nx">view</span><span class="p">,</span> <span class="p">{</span>
</div><div class='line' id='LC10'>	<span class="cm">/***
</div><div class='line' id='LC11'>	 * 渲染函数
</div><div class='line' id='LC12'>	 * @param {} target
</div><div class='line' id='LC13'>	 * @param {} container
</div><div class='line' id='LC14'>	 * @param {} frozen
</div><div class='line' id='LC15'>	 */</span>
</div><div class='line' id='LC16'>	<span class="nl">render</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="nx">container</span><span class="p">,</span> <span class="nx">frozen</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC17'>		<span class="kd">var</span> <span class="nx">state</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC18'>		<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC19'>		<span class="kd">var</span> <span class="nx">rows</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">rows</span> <span class="o">||</span> <span class="p">[];</span>
</div><div class='line' id='LC20'>		<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">rows</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC21'>			<span class="k">return</span><span class="p">;</span>
</div><div class='line' id='LC22'>		<span class="p">}</span>
</div><div class='line' id='LC23'>		<span class="kd">var</span> <span class="nx">fields</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="nx">target</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getColumnFields'</span><span class="p">,</span> <span class="nx">frozen</span><span class="p">);</span>
</div><div class='line' id='LC24'>
</div><div class='line' id='LC25'>		<span class="k">if</span> <span class="p">(</span><span class="nx">frozen</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC26'>			<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">rownumbers</span> <span class="o">||</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span> <span class="o">&amp;&amp;</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span><span class="p">.</span><span class="nx">length</span><span class="p">)))</span> <span class="p">{</span>
</div><div class='line' id='LC27'>				<span class="k">return</span><span class="p">;</span>
</div><div class='line' id='LC28'>			<span class="p">}</span>
</div><div class='line' id='LC29'>		<span class="p">}</span>
</div><div class='line' id='LC30'>
</div><div class='line' id='LC31'>		<span class="kd">var</span> <span class="nx">index</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">index</span><span class="p">;</span>
</div><div class='line' id='LC32'>		<span class="kd">var</span> <span class="nx">classValue</span> <span class="o">=</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC33'>		<span class="kd">var</span> <span class="nx">styleValue</span> <span class="o">=</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC34'>		<span class="kd">var</span> <span class="nx">style</span> <span class="o">=</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC35'>		<span class="kd">var</span> <span class="nx">table</span> <span class="o">=</span> <span class="p">[</span><span class="s1">'&lt;table class="datagrid-btable" cellspacing="0" cellpadding="0" border="0"&gt;&lt;tbody&gt;'</span><span class="p">];</span>
</div><div class='line' id='LC36'>		<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">rows</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC37'>			<span class="kd">var</span> <span class="nx">css</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">rowStyler</span> <span class="p">?</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">rowStyler</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span>
</div><div class='line' id='LC38'>					<span class="nx">rows</span><span class="p">[</span><span class="nx">i</span><span class="p">])</span> <span class="p">:</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC39'>			<span class="k">if</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">css</span> <span class="o">==</span> <span class="s1">'string'</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC40'>				<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">;</span>
</div><div class='line' id='LC41'>			<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">css</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC42'>				<span class="nx">classValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">[</span><span class="s1">'class'</span><span class="p">]</span> <span class="o">||</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC43'>				<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">[</span><span class="s1">'style'</span><span class="p">]</span> <span class="o">||</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC44'>			<span class="p">}</span>
</div><div class='line' id='LC45'>			<span class="kd">var</span> <span class="nx">cls</span> <span class="o">=</span> <span class="s1">'class="datagrid-row '</span>
</div><div class='line' id='LC46'>					<span class="o">+</span> <span class="p">(</span><span class="nx">index</span> <span class="o">%</span> <span class="mi">2</span> <span class="o">&amp;&amp;</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">striped</span> <span class="p">?</span> <span class="s1">'datagrid-row-alt '</span> <span class="p">:</span> <span class="s1">' '</span><span class="p">)</span>
</div><div class='line' id='LC47'>					<span class="o">+</span> <span class="nx">classValue</span> <span class="o">+</span> <span class="s1">'"'</span><span class="p">;</span>
</div><div class='line' id='LC48'>					
</div><div class='line' id='LC49'>			<span class="k">if</span><span class="p">(</span><span class="nx">frozen</span><span class="p">){</span>
</div><div class='line' id='LC50'>				<span class="nx">style</span> <span class="o">=</span> <span class="s1">'style="height:'</span><span class="o">+</span><span class="nx">opts</span><span class="p">.</span><span class="nx">rowHeight</span><span class="o">+</span><span class="s1">'px;"'</span>
</div><div class='line' id='LC51'>			<span class="p">}</span><span class="k">else</span><span class="p">{</span>
</div><div class='line' id='LC52'>				<span class="nx">style</span> <span class="o">=</span> <span class="nx">styleValue</span> <span class="p">?</span> <span class="s1">'style="'</span> <span class="o">+</span> <span class="nx">styleValue</span> <span class="o">+</span> <span class="s1">'"'</span> <span class="p">:</span> <span class="s1">'style="height:25px;"'</span><span class="p">;</span>
</div><div class='line' id='LC53'>			<span class="p">}</span>
</div><div class='line' id='LC54'>			<span class="kd">var</span> <span class="nx">rowId</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">rowIdPrefix</span> <span class="o">+</span> <span class="s1">'-'</span> <span class="o">+</span> <span class="p">(</span><span class="nx">frozen</span> <span class="p">?</span> <span class="mi">1</span> <span class="p">:</span> <span class="mi">2</span><span class="p">)</span> <span class="o">+</span> <span class="s1">'-'</span>
</div><div class='line' id='LC55'>					<span class="o">+</span> <span class="nx">index</span><span class="p">;</span>
</div><div class='line' id='LC56'>			<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;tr id="'</span> <span class="o">+</span> <span class="nx">rowId</span> <span class="o">+</span> <span class="s1">'" datagrid-row-index="'</span> <span class="o">+</span> <span class="nx">index</span>
</div><div class='line' id='LC57'>					<span class="o">+</span> <span class="s1">'" '</span> <span class="o">+</span> <span class="nx">cls</span> <span class="o">+</span> <span class="s1">' '</span> <span class="o">+</span> <span class="nx">style</span> <span class="o">+</span> <span class="s1">'&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC58'>			<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">renderRow</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">fields</span><span class="p">,</span> <span class="nx">frozen</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span>
</div><div class='line' id='LC59'>					<span class="nx">rows</span><span class="p">[</span><span class="nx">i</span><span class="p">]));</span>
</div><div class='line' id='LC60'>			<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/tr&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC61'>
</div><div class='line' id='LC62'>			<span class="c1">// render the detail row
</div><div class='line' id='LC63'></span>			<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">detailFormatter</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC64'>				<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;tr style="display:none;"&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC65'>				<span class="k">if</span> <span class="p">(</span><span class="nx">frozen</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC66'>					<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;td colspan='</span> <span class="o">+</span> <span class="p">(</span><span class="nx">fields</span><span class="p">.</span><span class="nx">length</span> <span class="o">+</span> <span class="mi">2</span><span class="p">)</span>
</div><div class='line' id='LC67'>							<span class="o">+</span> <span class="s1">' style="border-right:0"&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC68'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC69'>					<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;td colspan='</span> <span class="o">+</span> <span class="p">(</span><span class="nx">fields</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="o">+</span> <span class="s1">'&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC70'>				<span class="p">}</span>
</div><div class='line' id='LC71'>				<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;div class="datagrid-row-detail"&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC72'>				<span class="k">if</span> <span class="p">(</span><span class="nx">frozen</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC73'>					<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&amp;nbsp;'</span><span class="p">);</span>
</div><div class='line' id='LC74'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC75'>					<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">detailFormatter</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="nx">i</span><span class="p">,</span> <span class="nx">rows</span><span class="p">[</span><span class="nx">i</span><span class="p">]));</span>
</div><div class='line' id='LC76'>				<span class="p">}</span>
</div><div class='line' id='LC77'>				<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/div&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC78'>				<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/td&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC79'>				<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/tr&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC80'>			<span class="p">}</span>
</div><div class='line' id='LC81'>			<span class="nx">index</span><span class="o">++</span><span class="p">;</span>
</div><div class='line' id='LC82'>		<span class="p">}</span>
</div><div class='line' id='LC83'>		<span class="nx">table</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/tbody&gt;&lt;/table&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC84'>		<span class="nx">$</span><span class="p">(</span><span class="nx">container</span><span class="p">).</span><span class="nx">html</span><span class="p">(</span><span class="nx">table</span><span class="p">.</span><span class="nx">join</span><span class="p">(</span><span class="s1">''</span><span class="p">));</span>
</div><div class='line' id='LC85'>		
</div><div class='line' id='LC86'>	<span class="p">},</span>
</div><div class='line' id='LC87'>	<span class="cm">/**
</div><div class='line' id='LC88'>	 * 渲染行,这里个高度都是auto,可以在col里面来做style限制
</div><div class='line' id='LC89'>	 * @param {} target
</div><div class='line' id='LC90'>	 * @param {} fields
</div><div class='line' id='LC91'>	 * @param {} frozen
</div><div class='line' id='LC92'>	 * @param {} rowIndex
</div><div class='line' id='LC93'>	 * @param {} rowData
</div><div class='line' id='LC94'>	 * @return {}
</div><div class='line' id='LC95'>	 */</span>
</div><div class='line' id='LC96'>	<span class="nl">renderRow</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="nx">fields</span><span class="p">,</span> <span class="nx">frozen</span><span class="p">,</span> <span class="nx">rowIndex</span><span class="p">,</span> <span class="nx">rowData</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC97'>		<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC98'>
</div><div class='line' id='LC99'>		<span class="kd">var</span> <span class="nx">cc</span> <span class="o">=</span> <span class="p">[];</span>
</div><div class='line' id='LC100'>		<span class="c1">//添加行号
</div><div class='line' id='LC101'></span>		<span class="k">if</span> <span class="p">(</span><span class="nx">frozen</span> <span class="o">&amp;&amp;</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">rownumbers</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC102'>			<span class="kd">var</span> <span class="nx">rownumber</span> <span class="o">=</span> <span class="nx">rowIndex</span> <span class="o">+</span> <span class="mi">1</span><span class="p">;</span>
</div><div class='line' id='LC103'>			<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">pagination</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC104'>				<span class="nx">rownumber</span> <span class="o">+=</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">pageNumber</span> <span class="o">-</span> <span class="mi">1</span><span class="p">)</span> <span class="o">*</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">pageSize</span><span class="p">;</span>
</div><div class='line' id='LC105'>			<span class="p">}</span>
</div><div class='line' id='LC106'>			<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;td class="datagrid-td-rownumber"&gt;&lt;div class="datagrid-cell-rownumber" style="text-align:center"&gt;'</span>
</div><div class='line' id='LC107'>							<span class="o">+</span> <span class="nx">rownumber</span> <span class="o">+</span> <span class="s1">'&lt;/div&gt;&lt;/td&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC108'>		<span class="p">}</span>
</div><div class='line' id='LC109'>		<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">fields</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC110'>			<span class="kd">var</span> <span class="nx">field</span> <span class="o">=</span> <span class="nx">fields</span><span class="p">[</span><span class="nx">i</span><span class="p">];</span>
</div><div class='line' id='LC111'>			<span class="kd">var</span> <span class="nx">col</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="nx">target</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getColumnOption'</span><span class="p">,</span> <span class="nx">field</span><span class="p">);</span>
</div><div class='line' id='LC112'>			<span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC113'>				<span class="kd">var</span> <span class="nx">value</span> <span class="o">=</span> <span class="nx">rowData</span><span class="p">[</span><span class="nx">field</span><span class="p">];</span> <span class="c1">// the field value
</div><div class='line' id='LC114'></span>				<span class="kd">var</span> <span class="nx">css</span> <span class="o">=</span> <span class="nx">col</span><span class="p">.</span><span class="nx">styler</span>
</div><div class='line' id='LC115'>						<span class="p">?</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">styler</span><span class="p">(</span><span class="nx">value</span><span class="p">,</span> <span class="nx">rowData</span><span class="p">,</span> <span class="nx">rowIndex</span><span class="p">)</span> <span class="o">||</span> <span class="s1">''</span><span class="p">)</span>
</div><div class='line' id='LC116'>						<span class="p">:</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC117'>				<span class="kd">var</span> <span class="nx">classValue</span> <span class="o">=</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC118'>				<span class="kd">var</span> <span class="nx">styleValue</span> <span class="o">=</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC119'>				<span class="k">if</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">css</span> <span class="o">==</span> <span class="s1">'string'</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC120'>					<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">;</span>
</div><div class='line' id='LC121'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">cc</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC122'>					<span class="nx">classValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">[</span><span class="s1">'class'</span><span class="p">]</span> <span class="o">||</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC123'>					<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">[</span><span class="s1">'style'</span><span class="p">]</span> <span class="o">||</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC124'>				<span class="p">}</span>
</div><div class='line' id='LC125'>				<span class="kd">var</span> <span class="nx">cls</span> <span class="o">=</span> <span class="nx">classValue</span> <span class="p">?</span> <span class="s1">'class="'</span> <span class="o">+</span> <span class="nx">classValue</span> <span class="o">+</span> <span class="s1">'"'</span> <span class="p">:</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC126'>				<span class="kd">var</span> <span class="nx">style</span> <span class="o">=</span> <span class="nx">col</span><span class="p">.</span><span class="nx">hidden</span>
</div><div class='line' id='LC127'>						<span class="p">?</span> <span class="s1">'style="display:none;'</span> <span class="o">+</span> <span class="nx">styleValue</span> <span class="o">+</span> <span class="s1">'"'</span>
</div><div class='line' id='LC128'>						<span class="p">:</span> <span class="p">(</span><span class="nx">styleValue</span> <span class="p">?</span> <span class="s1">'style="'</span> <span class="o">+</span> <span class="nx">styleValue</span> <span class="o">+</span> <span class="s1">'"'</span> <span class="p">:</span> <span class="s1">''</span><span class="p">);</span>
</div><div class='line' id='LC129'>
</div><div class='line' id='LC130'>				<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;td field="'</span> <span class="o">+</span> <span class="nx">field</span> <span class="o">+</span> <span class="s1">'" '</span> <span class="o">+</span> <span class="nx">cls</span> <span class="o">+</span> <span class="s1">' '</span> <span class="o">+</span> <span class="nx">style</span> <span class="o">+</span> <span class="s1">'&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC131'>
</div><div class='line' id='LC132'>				<span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">checkbox</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC133'>					<span class="nx">style</span> <span class="o">=</span> <span class="s1">'height:15;'</span><span class="p">;</span>
</div><div class='line' id='LC134'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">expander</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC135'>					<span class="nx">style</span> <span class="o">=</span> <span class="s2">"text-align:center;height:15;"</span><span class="p">;</span>
</div><div class='line' id='LC136'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC137'>					<span class="nx">style</span> <span class="o">=</span> <span class="nx">styleValue</span><span class="p">;</span>
</div><div class='line' id='LC138'>					<span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">align</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC139'>						<span class="nx">style</span> <span class="o">+=</span> <span class="s1">';text-align:'</span> <span class="o">+</span> <span class="nx">col</span><span class="p">.</span><span class="nx">align</span> <span class="o">+</span> <span class="s1">';'</span>
</div><div class='line' id='LC140'>					<span class="p">}</span>
</div><div class='line' id='LC141'>					<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">opts</span><span class="p">.</span><span class="nx">nowrap</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC142'>						<span class="nx">style</span> <span class="o">+=</span> <span class="s1">';white-space:normal;height:auto;'</span><span class="p">;</span>
</div><div class='line' id='LC143'>					<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">autoRowHeight</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC144'>						<span class="nx">style</span> <span class="o">+=</span> <span class="s1">';height:auto;'</span><span class="p">;</span>
</div><div class='line' id='LC145'>					<span class="p">}</span>
</div><div class='line' id='LC146'>				<span class="p">}</span>
</div><div class='line' id='LC147'>
</div><div class='line' id='LC148'>				<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;div style="'</span> <span class="o">+</span> <span class="nx">style</span> <span class="o">+</span> <span class="s1">'" '</span><span class="p">);</span>
</div><div class='line' id='LC149'>				<span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">checkbox</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC150'>					<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'class="datagrid-cell-check'</span><span class="p">);</span>
</div><div class='line' id='LC151'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC152'>					<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'class="datagrid-cell '</span> <span class="o">+</span> <span class="nx">col</span><span class="p">.</span><span class="nx">cellClass</span><span class="p">);</span>
</div><div class='line' id='LC153'>				<span class="p">}</span>
</div><div class='line' id='LC154'>				<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'"&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC155'>
</div><div class='line' id='LC156'>				<span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">checkbox</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC157'>					<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;input type="checkbox" name="'</span> <span class="o">+</span> <span class="nx">field</span>
</div><div class='line' id='LC158'>							<span class="o">+</span> <span class="s1">'" value="'</span> <span class="o">+</span> <span class="p">(</span><span class="nx">value</span> <span class="o">!=</span> <span class="kc">undefined</span> <span class="p">?</span> <span class="nx">value</span> <span class="p">:</span> <span class="s1">''</span><span class="p">)</span>
</div><div class='line' id='LC159'>							<span class="o">+</span> <span class="s1">'"&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC160'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">expander</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC161'>					<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;span class="datagrid-row-expander datagrid-row-expand" style="display:inline-block;width:25px;height:auto;cursor:pointer;" /&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC162'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">formatter</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC163'>					<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">formatter</span><span class="p">(</span><span class="nx">value</span><span class="p">,</span> <span class="nx">rowData</span><span class="p">,</span> <span class="nx">rowIndex</span><span class="p">));</span>
</div><div class='line' id='LC164'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC165'>					<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="nx">value</span><span class="p">);</span>
</div><div class='line' id='LC166'>				<span class="p">}</span>
</div><div class='line' id='LC167'>
</div><div class='line' id='LC168'>				<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/div&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC169'>				<span class="nx">cc</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="s1">'&lt;/td&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC170'>			<span class="p">}</span>
</div><div class='line' id='LC171'>		<span class="p">}</span>
</div><div class='line' id='LC172'>		<span class="k">return</span> <span class="nx">cc</span><span class="p">.</span><span class="nx">join</span><span class="p">(</span><span class="s1">''</span><span class="p">);</span>
</div><div class='line' id='LC173'>	<span class="p">},</span>
</div><div class='line' id='LC174'>
</div><div class='line' id='LC175'>	<span class="nl">bindEvents</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC176'>		<span class="kd">var</span> <span class="nx">state</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC177'>		<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC178'>		<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC179'>		<span class="kd">var</span> <span class="nx">body</span> <span class="o">=</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">body1</span><span class="p">.</span><span class="nx">add</span><span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">);</span>
</div><div class='line' id='LC180'>		<span class="kd">var</span> <span class="nx">clickHandler</span> <span class="o">=</span> <span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">body</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="s1">'events'</span><span class="p">)</span> <span class="o">||</span> <span class="nx">$</span><span class="p">.</span><span class="nx">_data</span><span class="p">(</span><span class="nx">body</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span>
</div><div class='line' id='LC181'>				<span class="s1">'events'</span><span class="p">)).</span><span class="nx">click</span><span class="p">[</span><span class="mi">0</span><span class="p">].</span><span class="nx">handler</span><span class="p">;</span>
</div><div class='line' id='LC182'>		<span class="nx">body</span><span class="p">.</span><span class="nx">unbind</span><span class="p">(</span><span class="s1">'click'</span><span class="p">).</span><span class="nx">bind</span><span class="p">(</span><span class="s1">'click'</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC183'>					<span class="kd">var</span> <span class="nx">tt</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC184'>					<span class="kd">var</span> <span class="nx">tr</span> <span class="o">=</span> <span class="nx">tt</span><span class="p">.</span><span class="nx">closest</span><span class="p">(</span><span class="s1">'tr.datagrid-row'</span><span class="p">);</span>
</div><div class='line' id='LC185'>					<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">tr</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC186'>						<span class="k">return</span>
</div><div class='line' id='LC187'>					<span class="p">}</span>
</div><div class='line' id='LC188'>					<span class="k">if</span> <span class="p">(</span><span class="nx">tt</span><span class="p">.</span><span class="nx">hasClass</span><span class="p">(</span><span class="s1">'datagrid-row-expander'</span><span class="p">))</span> <span class="p">{</span>
</div><div class='line' id='LC189'>						<span class="kd">var</span> <span class="nx">rowIndex</span> <span class="o">=</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">tr</span><span class="p">.</span><span class="nx">attr</span><span class="p">(</span><span class="s1">'datagrid-row-index'</span><span class="p">));</span>
</div><div class='line' id='LC190'>						<span class="k">if</span> <span class="p">(</span><span class="nx">tt</span><span class="p">.</span><span class="nx">hasClass</span><span class="p">(</span><span class="s1">'datagrid-row-expand'</span><span class="p">))</span> <span class="p">{</span>
</div><div class='line' id='LC191'>							<span class="nx">$</span><span class="p">(</span><span class="nx">target</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'expandRow'</span><span class="p">,</span> <span class="nx">rowIndex</span><span class="p">);</span>
</div><div class='line' id='LC192'>						<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC193'>							<span class="nx">$</span><span class="p">(</span><span class="nx">target</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'collapseRow'</span><span class="p">,</span> <span class="nx">rowIndex</span><span class="p">);</span>
</div><div class='line' id='LC194'>						<span class="p">}</span>
</div><div class='line' id='LC195'>						<span class="nx">$</span><span class="p">(</span><span class="nx">target</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'fixRowHeight'</span><span class="p">);</span>
</div><div class='line' id='LC196'>
</div><div class='line' id='LC197'>					<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC198'>						<span class="nx">clickHandler</span><span class="p">(</span><span class="nx">e</span><span class="p">);</span>
</div><div class='line' id='LC199'>					<span class="p">}</span>
</div><div class='line' id='LC200'>					<span class="nx">e</span><span class="p">.</span><span class="nx">stopPropagation</span><span class="p">();</span>
</div><div class='line' id='LC201'>				<span class="p">});</span>
</div><div class='line' id='LC202'>	<span class="p">},</span>
</div><div class='line' id='LC203'>
</div><div class='line' id='LC204'>	<span class="nl">onBeforeRender</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC205'>		<span class="kd">var</span> <span class="nx">state</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC206'>		<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC207'>		<span class="c1">//这个是用来限制显示行数的
</div><div class='line' id='LC208'></span>		<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC209'>		<span class="kd">var</span> <span class="nx">view</span> <span class="o">=</span> <span class="k">this</span><span class="p">;</span>
</div><div class='line' id='LC210'>		<span class="cm">/**
</div><div class='line' id='LC211'>		 * 设置行高,这个地方需要注意,如果不同行高,比如有图片或者其他的东西,请在rowStyle设置行高
</div><div class='line' id='LC212'>		 * 不然无法计算高度,并且调用rowStyler方法传入职为null这个需要注意下
</div><div class='line' id='LC213'>		 * 解析方法就是下面的,所以请不要添加空格什么的
</div><div class='line' id='LC214'>		 */</span>
</div><div class='line' id='LC215'>		<span class="nx">opts</span><span class="p">.</span><span class="nx">rowHeight</span> <span class="o">=</span> <span class="nx">calculateDataGridTrStyleHeight</span><span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">rowStyler</span>
</div><div class='line' id='LC216'>				<span class="p">?</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">rowStyler</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="kc">null</span><span class="p">,</span> <span class="kc">null</span><span class="p">,</span> <span class="kc">null</span><span class="p">)</span>
</div><div class='line' id='LC217'>				<span class="p">:</span> <span class="s1">''</span><span class="p">);</span>
</div><div class='line' id='LC218'>		<span class="cm">/**
</div><div class='line' id='LC219'>		 * 设置页行数,感觉每次滚动的条数在4行的样子，所以多渲染6行，chrome几乎没有感觉，ieie基本也没有啥感觉,
</div><div class='line' id='LC220'>		 * 这个+10可以自己调整下
</div><div class='line' id='LC221'>		 */</span>
</div><div class='line' id='LC222'>		<span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">floor</span><span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">height</span><span class="p">()</span><span class="o">/</span><span class="nx">opts</span><span class="p">.</span><span class="nx">rowHeight</span><span class="p">)</span><span class="o">+</span><span class="mi">10</span><span class="p">;</span>
</div><div class='line' id='LC223'>		<span class="c1">//这里用来缓存数据
</div><div class='line' id='LC224'></span>		<span class="nx">state</span><span class="p">.</span><span class="nx">data</span><span class="p">.</span><span class="nx">cacheRows</span>  <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">data</span><span class="p">.</span><span class="nx">rows</span><span class="p">;</span>
</div><div class='line' id='LC225'>		<span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getRow</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">t</span><span class="p">,</span> <span class="nx">p</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC226'>			<span class="kd">var</span> <span class="nx">index</span> <span class="o">=</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">p</span> <span class="o">==</span> <span class="s1">'object'</span><span class="p">)</span>
</div><div class='line' id='LC227'>					<span class="p">?</span> <span class="nx">p</span><span class="p">.</span><span class="nx">attr</span><span class="p">(</span><span class="s1">'datagrid-row-index'</span><span class="p">)</span>
</div><div class='line' id='LC228'>					<span class="p">:</span> <span class="nx">p</span><span class="p">;</span>
</div><div class='line' id='LC229'>			<span class="kd">var</span> <span class="nx">row</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">t</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">data</span><span class="p">.</span><span class="nx">rows</span><span class="p">[</span><span class="nx">index</span><span class="p">];</span>
</div><div class='line' id='LC230'>			<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">row</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC231'>				<span class="kd">var</span> <span class="nx">v</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="nx">t</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'options'</span><span class="p">).</span><span class="nx">view</span><span class="p">;</span>
</div><div class='line' id='LC232'>				<span class="nx">row</span> <span class="o">=</span> <span class="nx">v</span><span class="p">.</span><span class="nx">rows</span><span class="p">[</span><span class="nx">index</span> <span class="o">-</span> <span class="nx">v</span><span class="p">.</span><span class="nx">index</span><span class="p">];</span>
</div><div class='line' id='LC233'>			<span class="p">}</span>
</div><div class='line' id='LC234'>			<span class="k">return</span> <span class="nx">row</span><span class="p">;</span>
</div><div class='line' id='LC235'>		<span class="p">};</span>
</div><div class='line' id='LC236'>
</div><div class='line' id='LC237'>		<span class="nx">dc</span><span class="p">.</span><span class="nx">body1</span><span class="p">.</span><span class="nx">add</span><span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">).</span><span class="nx">empty</span><span class="p">();</span>
</div><div class='line' id='LC238'>		<span class="k">this</span><span class="p">.</span><span class="nx">rows</span> <span class="o">=</span> <span class="kc">undefined</span><span class="p">;</span> <span class="c1">// the rows to be rendered
</div><div class='line' id='LC239'></span>		<span class="k">this</span><span class="p">.</span><span class="nx">r1</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">r2</span> <span class="o">=</span> <span class="p">[];</span> <span class="c1">// the first part and last part of rows
</div><div class='line' id='LC240'></span>
</div><div class='line' id='LC241'>		<span class="nx">init</span><span class="p">();</span>
</div><div class='line' id='LC242'>		<span class="nx">createHeaderExpander</span><span class="p">();</span>
</div><div class='line' id='LC243'>
</div><div class='line' id='LC244'>		<span class="kd">function</span> <span class="nx">init</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC245'>			<span class="nx">state</span><span class="p">.</span><span class="nx">onLoadSuccess</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">onLoadSuccess</span><span class="p">;</span>
</div><div class='line' id='LC246'>			<span class="nx">opts</span><span class="p">.</span><span class="nx">onLoadSuccess</span> <span class="o">=</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC247'>			<span class="p">};</span>
</div><div class='line' id='LC248'>			<span class="nx">setTimeout</span><span class="p">(</span><span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC249'>						<span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">unbind</span><span class="p">(</span><span class="s1">'.datagrid'</span><span class="p">).</span><span class="nx">bind</span><span class="p">(</span><span class="s1">'scroll.datagrid'</span><span class="p">,</span>
</div><div class='line' id='LC250'>								<span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC251'>									<span class="k">if</span> <span class="p">(</span><span class="nx">state</span><span class="p">.</span><span class="nx">onLoadSuccess</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC252'>										<span class="nx">opts</span><span class="p">.</span><span class="nx">onLoadSuccess</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">onLoadSuccess</span><span class="p">;</span> <span class="c1">// restore
</div><div class='line' id='LC253'></span>										<span class="nx">state</span><span class="p">.</span><span class="nx">onLoadSuccess</span> <span class="o">=</span> <span class="kc">undefined</span><span class="p">;</span>
</div><div class='line' id='LC254'>									<span class="p">}</span>
</div><div class='line' id='LC255'>									<span class="k">if</span> <span class="p">(</span><span class="nx">view</span><span class="p">.</span><span class="nx">scrollTimer</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC256'>										<span class="nx">clearTimeout</span><span class="p">(</span><span class="nx">view</span><span class="p">.</span><span class="nx">scrollTimer</span><span class="p">);</span>
</div><div class='line' id='LC257'>									<span class="p">}</span>
</div><div class='line' id='LC258'>									<span class="nx">view</span><span class="p">.</span><span class="nx">scrollTimer</span> <span class="o">=</span> <span class="nx">setTimeout</span><span class="p">(</span><span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC259'>												<span class="nx">scrolling</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">view</span><span class="p">);</span>
</div><div class='line' id='LC260'>											<span class="p">},</span> <span class="mi">50</span><span class="p">);</span>
</div><div class='line' id='LC261'>								<span class="p">});</span>
</div><div class='line' id='LC262'>						<span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">triggerHandler</span><span class="p">(</span><span class="s1">'scroll.datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC263'>					<span class="p">},</span> <span class="mi">0</span><span class="p">);</span>
</div><div class='line' id='LC264'>		<span class="p">}</span>
</div><div class='line' id='LC265'>		<span class="cm">/**
</div><div class='line' id='LC266'>		 * 这里才是重点,监听滚动条的移动
</div><div class='line' id='LC267'>		 * 动态渲染行
</div><div class='line' id='LC268'>		 */</span>
</div><div class='line' id='LC269'>		<span class="kd">function</span> <span class="nx">scrolling</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC270'>			<span class="k">if</span> <span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">is</span><span class="p">(</span><span class="s1">':empty'</span><span class="p">))</span> <span class="p">{</span>
</div><div class='line' id='LC271'>				<span class="nx">reload</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">);</span>
</div><div class='line' id='LC272'>			<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC273'>				<span class="kd">var</span> <span class="nx">firstTr</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="k">this</span><span class="p">.</span><span class="nx">index</span><span class="p">,</span> <span class="s1">'body'</span><span class="p">,</span> <span class="mi">2</span><span class="p">);</span>
</div><div class='line' id='LC274'>				<span class="kd">var</span> <span class="nx">lastTr</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="mi">0</span><span class="p">,</span> <span class="s1">'last'</span><span class="p">,</span> <span class="mi">2</span><span class="p">);</span>
</div><div class='line' id='LC275'>				<span class="kd">var</span> <span class="nx">headerHeight</span> <span class="o">=</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">view2</span><span class="p">.</span><span class="nx">children</span><span class="p">(</span><span class="s1">'div.datagrid-header'</span><span class="p">)</span>
</div><div class='line' id='LC276'>						<span class="p">.</span><span class="nx">outerHeight</span><span class="p">();</span>
</div><div class='line' id='LC277'>				<span class="kd">var</span> <span class="nx">top</span> <span class="o">=</span> <span class="nx">firstTr</span><span class="p">.</span><span class="nx">position</span><span class="p">().</span><span class="nx">top</span> <span class="o">-</span> <span class="nx">headerHeight</span><span class="p">;</span>
</div><div class='line' id='LC278'>				<span class="kd">var</span> <span class="nx">bottom</span> <span class="o">=</span> <span class="nx">lastTr</span><span class="p">.</span><span class="nx">position</span><span class="p">().</span><span class="nx">top</span> <span class="o">+</span> <span class="nx">lastTr</span><span class="p">.</span><span class="nx">outerHeight</span><span class="p">()</span>
</div><div class='line' id='LC279'>						<span class="o">-</span> <span class="nx">headerHeight</span><span class="p">;</span>
</div><div class='line' id='LC280'>
</div><div class='line' id='LC281'>				<span class="k">if</span> <span class="p">(</span><span class="nx">top</span> <span class="o">&gt;</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">height</span><span class="p">()</span> <span class="o">||</span> <span class="nx">bottom</span> <span class="o">&lt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC282'>					<span class="nx">reload</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">);</span>
</div><div class='line' id='LC283'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">top</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC284'>					<span class="kd">var</span> <span class="nx">page</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">floor</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">/</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">);</span>
</div><div class='line' id='LC285'>					<span class="k">this</span><span class="p">.</span><span class="nx">getRows</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">page</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span><span class="nx">rows</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC286'>								<span class="k">this</span><span class="p">.</span><span class="nx">r2</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">r1</span><span class="p">;</span>
</div><div class='line' id='LC287'>								<span class="k">this</span><span class="p">.</span><span class="nx">r1</span> <span class="o">=</span> <span class="nx">rows</span><span class="p">;</span>
</div><div class='line' id='LC288'>								<span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">=</span> <span class="p">(</span><span class="nx">page</span> <span class="o">-</span> <span class="mi">1</span><span class="p">)</span> <span class="o">*</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">;</span>
</div><div class='line' id='LC289'>								<span class="k">this</span><span class="p">.</span><span class="nx">rows</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">r1</span><span class="p">.</span><span class="nx">concat</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">r2</span><span class="p">);</span>
</div><div class='line' id='LC290'>								<span class="k">this</span><span class="p">.</span><span class="nx">populate</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC291'>							<span class="p">});</span>
</div><div class='line' id='LC292'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">bottom</span> <span class="o">&lt;</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">height</span><span class="p">())</span> <span class="p">{</span>
</div><div class='line' id='LC293'>					<span class="kd">var</span> <span class="nx">page</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">floor</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">/</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">)</span> <span class="o">+</span> <span class="mi">2</span><span class="p">;</span>
</div><div class='line' id='LC294'>					<span class="k">if</span> <span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">r2</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC295'>						<span class="nx">page</span><span class="o">++</span><span class="p">;</span>
</div><div class='line' id='LC296'>					<span class="p">}</span>
</div><div class='line' id='LC297'>					<span class="k">this</span><span class="p">.</span><span class="nx">getRows</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">page</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span><span class="nx">rows</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC298'>								<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="k">this</span><span class="p">.</span><span class="nx">r2</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC299'>									<span class="k">this</span><span class="p">.</span><span class="nx">r2</span> <span class="o">=</span> <span class="nx">rows</span><span class="p">;</span>
</div><div class='line' id='LC300'>								<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC301'>									<span class="k">this</span><span class="p">.</span><span class="nx">r1</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">r2</span><span class="p">;</span>
</div><div class='line' id='LC302'>									<span class="k">this</span><span class="p">.</span><span class="nx">r2</span> <span class="o">=</span> <span class="nx">rows</span><span class="p">;</span>
</div><div class='line' id='LC303'>									<span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">+=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">;</span>
</div><div class='line' id='LC304'>								<span class="p">}</span>
</div><div class='line' id='LC305'>								<span class="k">this</span><span class="p">.</span><span class="nx">rows</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">r1</span><span class="p">.</span><span class="nx">concat</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">r2</span><span class="p">);</span>
</div><div class='line' id='LC306'>								<span class="k">this</span><span class="p">.</span><span class="nx">populate</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC307'>							<span class="p">});</span>
</div><div class='line' id='LC308'>				<span class="p">}</span>
</div><div class='line' id='LC309'>			<span class="p">}</span>
</div><div class='line' id='LC310'>			<span class="cm">/**
</div><div class='line' id='LC311'>			 * 这里进行数据重载
</div><div class='line' id='LC312'>			 */</span>
</div><div class='line' id='LC313'>			<span class="kd">function</span> <span class="nx">reload</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC314'>				<span class="kd">var</span> <span class="nx">top</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">).</span><span class="nx">scrollTop</span><span class="p">();</span>
</div><div class='line' id='LC315'>				<span class="kd">var</span> <span class="nx">index</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">floor</span><span class="p">(</span><span class="nx">top</span> <span class="o">/</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">rowHeight</span><span class="p">);</span>
</div><div class='line' id='LC316'>				<span class="kd">var</span> <span class="nx">page</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">floor</span><span class="p">(</span><span class="nx">index</span> <span class="o">/</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">)</span> <span class="o">+</span> <span class="mi">1</span><span class="p">;</span>
</div><div class='line' id='LC317'>
</div><div class='line' id='LC318'>				<span class="k">this</span><span class="p">.</span><span class="nx">getRows</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">page</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span><span class="nx">rows</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC319'>							<span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">=</span> <span class="p">(</span><span class="nx">page</span> <span class="o">-</span> <span class="mi">1</span><span class="p">)</span> <span class="o">*</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">;</span>
</div><div class='line' id='LC320'>							<span class="k">this</span><span class="p">.</span><span class="nx">rows</span> <span class="o">=</span> <span class="nx">rows</span><span class="p">;</span>
</div><div class='line' id='LC321'>							<span class="k">this</span><span class="p">.</span><span class="nx">r1</span> <span class="o">=</span> <span class="nx">rows</span><span class="p">;</span>
</div><div class='line' id='LC322'>							<span class="k">this</span><span class="p">.</span><span class="nx">r2</span> <span class="o">=</span> <span class="p">[];</span>
</div><div class='line' id='LC323'>							<span class="k">this</span><span class="p">.</span><span class="nx">populate</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC324'>							<span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">triggerHandler</span><span class="p">(</span><span class="s1">'scroll.datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC325'>						<span class="p">});</span>
</div><div class='line' id='LC326'>			<span class="p">}</span>
</div><div class='line' id='LC327'>		<span class="p">}</span>
</div><div class='line' id='LC328'>		<span class="kd">function</span> <span class="nx">createHeaderExpander</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC329'>			<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">opts</span><span class="p">.</span><span class="nx">detailFormatter</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC330'>				<span class="k">return</span>
</div><div class='line' id='LC331'>			<span class="p">}</span>
</div><div class='line' id='LC332'>
</div><div class='line' id='LC333'>			<span class="kd">var</span> <span class="nx">t</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC334'>			<span class="kd">var</span> <span class="nx">hasExpander</span> <span class="o">=</span> <span class="kc">false</span><span class="p">;</span>
</div><div class='line' id='LC335'>			<span class="kd">var</span> <span class="nx">fields</span> <span class="o">=</span> <span class="nx">t</span><span class="p">.</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getColumnFields'</span><span class="p">,</span> <span class="kc">true</span><span class="p">).</span><span class="nx">concat</span><span class="p">(</span><span class="nx">t</span>
</div><div class='line' id='LC336'>					<span class="p">.</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getColumnFields'</span><span class="p">));</span>
</div><div class='line' id='LC337'>			<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">fields</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC338'>				<span class="kd">var</span> <span class="nx">col</span> <span class="o">=</span> <span class="nx">t</span><span class="p">.</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getColumnOption'</span><span class="p">,</span> <span class="nx">fields</span><span class="p">[</span><span class="nx">i</span><span class="p">]);</span>
</div><div class='line' id='LC339'>				<span class="k">if</span> <span class="p">(</span><span class="nx">col</span><span class="p">.</span><span class="nx">expander</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC340'>					<span class="nx">hasExpander</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span>
</div><div class='line' id='LC341'>					<span class="k">break</span><span class="p">;</span>
</div><div class='line' id='LC342'>				<span class="p">}</span>
</div><div class='line' id='LC343'>			<span class="p">}</span>
</div><div class='line' id='LC344'>			<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">hasExpander</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC345'>				<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span> <span class="o">&amp;&amp;</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC346'>					<span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span><span class="p">[</span><span class="mi">0</span><span class="p">].</span><span class="nx">splice</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="mi">0</span><span class="p">,</span> <span class="p">{</span>
</div><div class='line' id='LC347'>								<span class="na">field</span> <span class="p">:</span> <span class="s1">'_expander'</span><span class="p">,</span>
</div><div class='line' id='LC348'>								<span class="na">expander</span> <span class="p">:</span> <span class="kc">true</span><span class="p">,</span>
</div><div class='line' id='LC349'>								<span class="na">width</span> <span class="p">:</span> <span class="mi">24</span><span class="p">,</span>
</div><div class='line' id='LC350'>								<span class="na">resizable</span> <span class="p">:</span> <span class="kc">false</span><span class="p">,</span>
</div><div class='line' id='LC351'>								<span class="na">fixed</span> <span class="p">:</span> <span class="kc">true</span>
</div><div class='line' id='LC352'>							<span class="p">});</span>
</div><div class='line' id='LC353'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC354'>					<span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span> <span class="o">=</span> <span class="p">[[{</span>
</div><div class='line' id='LC355'>								<span class="na">field</span> <span class="p">:</span> <span class="s1">'_expander'</span><span class="p">,</span>
</div><div class='line' id='LC356'>								<span class="na">expander</span> <span class="p">:</span> <span class="kc">true</span><span class="p">,</span>
</div><div class='line' id='LC357'>								<span class="na">width</span> <span class="p">:</span> <span class="mi">24</span><span class="p">,</span>
</div><div class='line' id='LC358'>								<span class="na">resizable</span> <span class="p">:</span> <span class="kc">false</span><span class="p">,</span>
</div><div class='line' id='LC359'>								<span class="na">fixed</span> <span class="p">:</span> <span class="kc">true</span>
</div><div class='line' id='LC360'>							<span class="p">}]];</span>
</div><div class='line' id='LC361'>				<span class="p">}</span>
</div><div class='line' id='LC362'>
</div><div class='line' id='LC363'>				<span class="kd">var</span> <span class="nx">t</span> <span class="o">=</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">view1</span><span class="p">.</span><span class="nx">children</span><span class="p">(</span><span class="s1">'div.datagrid-header'</span><span class="p">).</span><span class="nx">find</span><span class="p">(</span><span class="s1">'table'</span><span class="p">);</span>
</div><div class='line' id='LC364'>				<span class="kd">var</span> <span class="nx">td</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="s1">'&lt;td rowspan="'</span>
</div><div class='line' id='LC365'>						<span class="o">+</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">frozenColumns</span><span class="p">.</span><span class="nx">length</span>
</div><div class='line' id='LC366'>						<span class="o">+</span> <span class="s1">'"&gt;&lt;div class="datagrid-header-expander" style="width:24px;"&gt;&lt;/div&gt;&lt;/td&gt;'</span><span class="p">);</span>
</div><div class='line' id='LC367'>				<span class="k">if</span> <span class="p">(</span><span class="nx">$</span><span class="p">(</span><span class="s1">'tr'</span><span class="p">,</span> <span class="nx">t</span><span class="p">).</span><span class="nx">length</span> <span class="o">==</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC368'>					<span class="nx">td</span><span class="p">.</span><span class="nx">wrap</span><span class="p">(</span><span class="s1">'&lt;tr&gt;&lt;/tr&gt;'</span><span class="p">).</span><span class="nx">parent</span><span class="p">().</span><span class="nx">appendTo</span><span class="p">(</span><span class="nx">$</span><span class="p">(</span><span class="s1">'tbody'</span><span class="p">,</span> <span class="nx">t</span><span class="p">));</span>
</div><div class='line' id='LC369'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">rownumbers</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC370'>					<span class="nx">td</span><span class="p">.</span><span class="nx">insertAfter</span><span class="p">(</span><span class="nx">t</span>
</div><div class='line' id='LC371'>							<span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">'td:has(div.datagrid-header-rownumber)'</span><span class="p">));</span>
</div><div class='line' id='LC372'>				<span class="p">}</span> <span class="k">else</span> <span class="p">{</span>
</div><div class='line' id='LC373'>					<span class="nx">td</span><span class="p">.</span><span class="nx">prependTo</span><span class="p">(</span><span class="nx">t</span><span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">'tr:first'</span><span class="p">));</span>
</div><div class='line' id='LC374'>				<span class="p">}</span>
</div><div class='line' id='LC375'>			<span class="p">}</span>
</div><div class='line' id='LC376'>
</div><div class='line' id='LC377'>			<span class="nx">setTimeout</span><span class="p">(</span><span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC378'>						<span class="nx">view</span><span class="p">.</span><span class="nx">bindEvents</span><span class="p">(</span><span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC379'>					<span class="p">},</span> <span class="mi">0</span><span class="p">);</span>
</div><div class='line' id='LC380'>		<span class="p">}</span>
</div><div class='line' id='LC381'>	<span class="p">},</span>
</div><div class='line' id='LC382'>
</div><div class='line' id='LC383'>	<span class="nl">onAfterRender</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC384'>		<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">datagrid</span><span class="p">.</span><span class="nx">defaults</span><span class="p">.</span><span class="nx">view</span><span class="p">.</span><span class="nx">onAfterRender</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">target</span><span class="p">);</span>
</div><div class='line' id='LC385'>		<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC386'>		<span class="kd">var</span> <span class="nx">footer</span> <span class="o">=</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">footer1</span><span class="p">.</span><span class="nx">add</span><span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">footer2</span><span class="p">);</span>
</div><div class='line' id='LC387'>		<span class="nx">footer</span><span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">'span.datagrid-row-expander'</span><span class="p">).</span><span class="nx">css</span><span class="p">(</span><span class="s1">'visibility'</span><span class="p">,</span> <span class="s1">'hidden'</span><span class="p">);</span>
</div><div class='line' id='LC388'>	<span class="p">},</span>
</div><div class='line' id='LC389'>	<span class="cm">/**
</div><div class='line' id='LC390'>	 * getRows 获取数据的地方
</div><div class='line' id='LC391'>	 * @param {} target
</div><div class='line' id='LC392'>	 * @param {} page
</div><div class='line' id='LC393'>	 * @param {} callback
</div><div class='line' id='LC394'>	 */</span>
</div><div class='line' id='LC395'>	<span class="nl">getRows</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="nx">page</span><span class="p">,</span> <span class="nx">callback</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC396'>		<span class="kd">var</span> <span class="nx">state</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC397'>		<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC398'>		<span class="kd">var</span> <span class="nx">index</span> <span class="o">=</span> <span class="p">(</span><span class="nx">page</span> <span class="o">-</span> <span class="mi">1</span><span class="p">)</span> <span class="o">*</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">;</span>
</div><div class='line' id='LC399'>		<span class="kd">var</span> <span class="nx">rows</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">data</span><span class="p">.</span><span class="nx">cacheRows</span><span class="p">.</span><span class="nx">slice</span><span class="p">(</span><span class="nx">index</span><span class="p">,</span> <span class="nx">index</span> <span class="o">+</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">viewPageSize</span><span class="p">);</span>
</div><div class='line' id='LC400'>		<span class="k">if</span> <span class="p">(</span><span class="nx">rows</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC401'>			<span class="nx">callback</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">rows</span><span class="p">);</span>
</div><div class='line' id='LC402'>		<span class="p">}</span>
</div><div class='line' id='LC403'>	<span class="p">},</span>
</div><div class='line' id='LC404'>
</div><div class='line' id='LC405'>	<span class="nl">populate</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">target</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC406'>		<span class="kd">var</span> <span class="nx">state</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">);</span>
</div><div class='line' id='LC407'>		<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC408'>		<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">state</span><span class="p">.</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC409'>		<span class="kd">var</span> <span class="nx">rowHeight</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">rowHeight</span><span class="p">;</span>
</div><div class='line' id='LC410'>
</div><div class='line' id='LC411'>		<span class="k">if</span> <span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">rows</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC412'>			<span class="nx">opts</span><span class="p">.</span><span class="nx">view</span><span class="p">.</span><span class="nx">render</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">view</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">,</span> <span class="kc">false</span><span class="p">);</span>
</div><div class='line' id='LC413'>			<span class="nx">opts</span><span class="p">.</span><span class="nx">view</span><span class="p">.</span><span class="nx">render</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">view</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">dc</span><span class="p">.</span><span class="nx">body1</span><span class="p">,</span> <span class="kc">true</span><span class="p">);</span>
</div><div class='line' id='LC414'>			<span class="nx">dc</span><span class="p">.</span><span class="nx">body1</span><span class="p">.</span><span class="nx">add</span><span class="p">(</span><span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">).</span><span class="nx">children</span><span class="p">(</span><span class="s1">'table.datagrid-btable'</span><span class="p">).</span><span class="nx">css</span><span class="p">({</span>
</div><div class='line' id='LC415'>				<span class="na">marginTop</span> <span class="p">:</span> <span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">*</span> <span class="nx">rowHeight</span><span class="p">,</span>
</div><div class='line' id='LC416'>				<span class="na">marginBottom</span> <span class="p">:</span> <span class="nx">state</span><span class="p">.</span><span class="nx">data</span><span class="p">.</span><span class="nx">cacheRows</span><span class="p">.</span><span class="nx">length</span> <span class="o">*</span> <span class="nx">rowHeight</span> <span class="o">-</span> <span class="k">this</span><span class="p">.</span><span class="nx">rows</span><span class="p">.</span><span class="nx">length</span>
</div><div class='line' id='LC417'>						<span class="o">*</span> <span class="nx">rowHeight</span> <span class="o">-</span> <span class="k">this</span><span class="p">.</span><span class="nx">index</span> <span class="o">*</span> <span class="nx">rowHeight</span>
</div><div class='line' id='LC418'>			<span class="p">});</span>
</div><div class='line' id='LC419'>		<span class="p">}</span>
</div><div class='line' id='LC420'>		<span class="k">if</span> <span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">rows</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC421'>
</div><div class='line' id='LC422'>			<span class="kd">var</span> <span class="nx">r</span> <span class="o">=</span> <span class="p">[];</span>
</div><div class='line' id='LC423'>			<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="k">this</span><span class="p">.</span><span class="nx">index</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC424'>				<span class="nx">r</span><span class="p">.</span><span class="nx">push</span><span class="p">({});</span>
</div><div class='line' id='LC425'>			<span class="p">}</span>
</div><div class='line' id='LC426'>			<span class="nx">state</span><span class="p">.</span><span class="nx">data</span><span class="p">.</span><span class="nx">rows</span> <span class="o">=</span> <span class="nx">r</span><span class="p">.</span><span class="nx">concat</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">rows</span><span class="p">);</span>
</div><div class='line' id='LC427'>			<span class="cm">/**
</div><div class='line' id='LC428'>			 * 这里是设置rows的条数，这个因为分页的，所以设置和当前页页相同
</div><div class='line' id='LC429'>			 */</span>
</div><div class='line' id='LC430'>			<span class="nx">opts</span><span class="p">.</span><span class="nx">onLoadSuccess</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">target</span><span class="p">,</span> <span class="p">{</span>
</div><div class='line' id='LC431'>						<span class="na">total</span> <span class="p">:</span> <span class="k">this</span><span class="p">.</span><span class="nx">rows</span><span class="p">.</span><span class="nx">length</span><span class="p">,</span>
</div><div class='line' id='LC432'>						<span class="na">rows</span> <span class="p">:</span> <span class="k">this</span><span class="p">.</span><span class="nx">rows</span>
</div><div class='line' id='LC433'>					<span class="p">});</span>
</div><div class='line' id='LC434'>		<span class="p">}</span>
</div><div class='line' id='LC435'>	<span class="p">}</span>
</div><div class='line' id='LC436'><span class="p">});</span>
</div><div class='line' id='LC437'>
</div><div class='line' id='LC438'><span class="nx">$</span><span class="p">.</span><span class="nx">extend</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">datagrid</span><span class="p">.</span><span class="nx">methods</span><span class="p">,</span> <span class="p">{</span>	
</div><div class='line' id='LC439'>			<span class="na">fixDetailRowHeight</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">jq</span><span class="p">,</span> <span class="nx">index</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC440'>				<span class="k">return</span> <span class="nx">jq</span><span class="p">.</span><span class="nx">each</span><span class="p">(</span><span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC441'>							<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC442'>							<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC443'>							<span class="kd">var</span> <span class="nx">tr1</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span> <span class="s1">'body'</span><span class="p">,</span> <span class="mi">1</span><span class="p">)</span>
</div><div class='line' id='LC444'>									<span class="p">.</span><span class="nx">next</span><span class="p">();</span>
</div><div class='line' id='LC445'>							<span class="kd">var</span> <span class="nx">tr2</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span> <span class="s1">'body'</span><span class="p">,</span> <span class="mi">2</span><span class="p">)</span>
</div><div class='line' id='LC446'>									<span class="p">.</span><span class="nx">next</span><span class="p">();</span>
</div><div class='line' id='LC447'>							<span class="k">if</span> <span class="p">(</span><span class="nx">tr2</span><span class="p">.</span><span class="nx">is</span><span class="p">(</span><span class="s1">':visible'</span><span class="p">))</span> <span class="p">{</span>
</div><div class='line' id='LC448'>								<span class="nx">tr1</span><span class="p">.</span><span class="nx">css</span><span class="p">(</span><span class="s1">'height'</span><span class="p">,</span> <span class="s1">''</span><span class="p">);</span>
</div><div class='line' id='LC449'>								<span class="nx">tr2</span><span class="p">.</span><span class="nx">css</span><span class="p">(</span><span class="s1">'height'</span><span class="p">,</span> <span class="s1">''</span><span class="p">);</span>
</div><div class='line' id='LC450'>								<span class="kd">var</span> <span class="nx">height</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">max</span><span class="p">(</span><span class="nx">tr1</span><span class="p">.</span><span class="nx">height</span><span class="p">(),</span> <span class="nx">tr2</span>
</div><div class='line' id='LC451'>												<span class="p">.</span><span class="nx">height</span><span class="p">());</span>
</div><div class='line' id='LC452'>								<span class="nx">tr1</span><span class="p">.</span><span class="nx">css</span><span class="p">(</span><span class="s1">'height'</span><span class="p">,</span> <span class="nx">height</span><span class="p">);</span>
</div><div class='line' id='LC453'>								<span class="nx">tr2</span><span class="p">.</span><span class="nx">css</span><span class="p">(</span><span class="s1">'height'</span><span class="p">,</span> <span class="nx">height</span><span class="p">);</span>
</div><div class='line' id='LC454'>							<span class="p">}</span>
</div><div class='line' id='LC455'>							<span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">triggerHandler</span><span class="p">(</span><span class="s1">'scroll'</span><span class="p">);</span>
</div><div class='line' id='LC456'>						<span class="p">});</span>
</div><div class='line' id='LC457'>			<span class="p">},</span>
</div><div class='line' id='LC458'>			<span class="na">getExpander</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">jq</span><span class="p">,</span> <span class="nx">index</span><span class="p">)</span> <span class="p">{</span> <span class="c1">// get row expander object
</div><div class='line' id='LC459'></span>				<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">jq</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC460'>				<span class="k">return</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="nx">jq</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="nx">index</span><span class="p">)</span>
</div><div class='line' id='LC461'>						<span class="p">.</span><span class="nx">find</span><span class="p">(</span><span class="s1">'span.datagrid-row-expander'</span><span class="p">);</span>
</div><div class='line' id='LC462'>			<span class="p">},</span>
</div><div class='line' id='LC463'>			<span class="c1">// get row detail container
</div><div class='line' id='LC464'></span>			<span class="na">getRowDetail</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">jq</span><span class="p">,</span> <span class="nx">index</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC465'>				<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="nx">jq</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">options</span><span class="p">;</span>
</div><div class='line' id='LC466'>				<span class="kd">var</span> <span class="nx">tr</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="nx">jq</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="nx">index</span><span class="p">,</span> <span class="s1">'body'</span><span class="p">,</span> <span class="mi">2</span><span class="p">);</span>
</div><div class='line' id='LC467'>				<span class="k">return</span> <span class="nx">tr</span><span class="p">.</span><span class="nx">next</span><span class="p">().</span><span class="nx">find</span><span class="p">(</span><span class="s1">'div.datagrid-row-detail'</span><span class="p">);</span>
</div><div class='line' id='LC468'>			<span class="p">},</span>
</div><div class='line' id='LC469'>			<span class="na">expandRow</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">jq</span><span class="p">,</span> <span class="nx">index</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC470'>				<span class="k">return</span> <span class="nx">jq</span><span class="p">.</span><span class="nx">each</span><span class="p">(</span><span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC471'>							<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'options'</span><span class="p">);</span>
</div><div class='line' id='LC472'>							<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC473'>							<span class="kd">var</span> <span class="nx">expander</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getExpander'</span><span class="p">,</span>
</div><div class='line' id='LC474'>									<span class="nx">index</span><span class="p">);</span>
</div><div class='line' id='LC475'>							<span class="k">if</span> <span class="p">(</span><span class="nx">expander</span><span class="p">.</span><span class="nx">hasClass</span><span class="p">(</span><span class="s1">'datagrid-row-expand'</span><span class="p">))</span> <span class="p">{</span>
</div><div class='line' id='LC476'>								<span class="nx">expander</span><span class="p">.</span><span class="nx">removeClass</span><span class="p">(</span><span class="s1">'datagrid-row-expand'</span><span class="p">)</span>
</div><div class='line' id='LC477'>										<span class="p">.</span><span class="nx">addClass</span><span class="p">(</span><span class="s1">'datagrid-row-collapse'</span><span class="p">);</span>
</div><div class='line' id='LC478'>								<span class="kd">var</span> <span class="nx">tr1</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span>
</div><div class='line' id='LC479'>										<span class="s1">'body'</span><span class="p">,</span> <span class="mi">1</span><span class="p">).</span><span class="nx">next</span><span class="p">();</span>
</div><div class='line' id='LC480'>								<span class="kd">var</span> <span class="nx">tr2</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span>
</div><div class='line' id='LC481'>										<span class="s1">'body'</span><span class="p">,</span> <span class="mi">2</span><span class="p">).</span><span class="nx">next</span><span class="p">();</span>
</div><div class='line' id='LC482'>								<span class="nx">tr1</span><span class="p">.</span><span class="nx">show</span><span class="p">();</span>
</div><div class='line' id='LC483'>								<span class="nx">tr2</span><span class="p">.</span><span class="nx">show</span><span class="p">();</span>
</div><div class='line' id='LC484'>								<span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'fixDetailRowHeight'</span><span class="p">,</span> <span class="nx">index</span><span class="p">);</span>
</div><div class='line' id='LC485'>								<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">onExpandRow</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC486'>									<span class="kd">var</span> <span class="nx">row</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getRows'</span><span class="p">)[</span><span class="nx">index</span><span class="p">];</span>
</div><div class='line' id='LC487'>									<span class="nx">opts</span><span class="p">.</span><span class="nx">onExpandRow</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span> <span class="nx">row</span><span class="p">);</span>
</div><div class='line' id='LC488'>								<span class="p">}</span>
</div><div class='line' id='LC489'>							<span class="p">}</span>
</div><div class='line' id='LC490'>						<span class="p">});</span>
</div><div class='line' id='LC491'>			<span class="p">},</span>
</div><div class='line' id='LC492'>			<span class="na">collapseRow</span> <span class="p">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">jq</span><span class="p">,</span> <span class="nx">index</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC493'>				<span class="k">return</span> <span class="nx">jq</span><span class="p">.</span><span class="nx">each</span><span class="p">(</span><span class="kd">function</span><span class="p">()</span> <span class="p">{</span>
</div><div class='line' id='LC494'>							<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'options'</span><span class="p">);</span>
</div><div class='line' id='LC495'>							<span class="kd">var</span> <span class="nx">dc</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="s1">'datagrid'</span><span class="p">).</span><span class="nx">dc</span><span class="p">;</span>
</div><div class='line' id='LC496'>							<span class="kd">var</span> <span class="nx">expander</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getExpander'</span><span class="p">,</span>
</div><div class='line' id='LC497'>									<span class="nx">index</span><span class="p">);</span>
</div><div class='line' id='LC498'>							<span class="k">if</span> <span class="p">(</span><span class="nx">expander</span><span class="p">.</span><span class="nx">hasClass</span><span class="p">(</span><span class="s1">'datagrid-row-collapse'</span><span class="p">))</span> <span class="p">{</span>
</div><div class='line' id='LC499'>								<span class="nx">expander</span><span class="p">.</span><span class="nx">removeClass</span><span class="p">(</span><span class="s1">'datagrid-row-collapse'</span><span class="p">)</span>
</div><div class='line' id='LC500'>										<span class="p">.</span><span class="nx">addClass</span><span class="p">(</span><span class="s1">'datagrid-row-expand'</span><span class="p">);</span>
</div><div class='line' id='LC501'>								<span class="kd">var</span> <span class="nx">tr1</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span>
</div><div class='line' id='LC502'>										<span class="s1">'body'</span><span class="p">,</span> <span class="mi">1</span><span class="p">).</span><span class="nx">next</span><span class="p">();</span>
</div><div class='line' id='LC503'>								<span class="kd">var</span> <span class="nx">tr2</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">finder</span><span class="p">.</span><span class="nx">getTr</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span>
</div><div class='line' id='LC504'>										<span class="s1">'body'</span><span class="p">,</span> <span class="mi">2</span><span class="p">).</span><span class="nx">next</span><span class="p">();</span>
</div><div class='line' id='LC505'>								<span class="nx">tr1</span><span class="p">.</span><span class="nx">hide</span><span class="p">();</span>
</div><div class='line' id='LC506'>								<span class="nx">tr2</span><span class="p">.</span><span class="nx">hide</span><span class="p">();</span>
</div><div class='line' id='LC507'>								<span class="nx">dc</span><span class="p">.</span><span class="nx">body2</span><span class="p">.</span><span class="nx">triggerHandler</span><span class="p">(</span><span class="s1">'scroll'</span><span class="p">);</span>
</div><div class='line' id='LC508'>								<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">onCollapseRow</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC509'>									<span class="kd">var</span> <span class="nx">row</span> <span class="o">=</span> <span class="nx">$</span><span class="p">(</span><span class="k">this</span><span class="p">).</span><span class="nx">datagrid</span><span class="p">(</span><span class="s1">'getRows'</span><span class="p">)[</span><span class="nx">index</span><span class="p">];</span>
</div><div class='line' id='LC510'>									<span class="nx">opts</span><span class="p">.</span><span class="nx">onCollapseRow</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">index</span><span class="p">,</span> <span class="nx">row</span><span class="p">);</span>
</div><div class='line' id='LC511'>								<span class="p">}</span>
</div><div class='line' id='LC512'>							<span class="p">}</span>
</div><div class='line' id='LC513'>						<span class="p">});</span>
</div><div class='line' id='LC514'>			<span class="p">}</span>
</div><div class='line' id='LC515'>		<span class="p">});</span>
</div><div class='line' id='LC516'><span class="kd">function</span> <span class="nx">calculateDataGridTrStyleHeight</span><span class="p">(</span><span class="nx">css</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC517'>	<span class="kd">var</span> <span class="nx">styleValue</span><span class="p">;</span>
</div><div class='line' id='LC518'>	<span class="k">if</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">css</span> <span class="o">==</span> <span class="s1">'string'</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC519'>		<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">;</span>
</div><div class='line' id='LC520'>	<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">css</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC521'>		<span class="nx">classValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">[</span><span class="s1">'class'</span><span class="p">]</span> <span class="o">||</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC522'>		<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">css</span><span class="p">[</span><span class="s1">'style'</span><span class="p">]</span> <span class="o">||</span> <span class="s1">''</span><span class="p">;</span>
</div><div class='line' id='LC523'>	<span class="p">}</span>
</div><div class='line' id='LC524'>
</div><div class='line' id='LC525'>	<span class="k">if</span> <span class="p">(</span><span class="nx">styleValue</span> <span class="o">&amp;&amp;</span> <span class="nx">styleValue</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">"height"</span><span class="p">)</span> <span class="o">&gt;</span> <span class="o">-</span><span class="mi">1</span><span class="p">)</span> <span class="p">{</span>
</div><div class='line' id='LC526'>		<span class="kd">var</span> <span class="nx">index</span> <span class="o">=</span> <span class="nx">styleValue</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">"height"</span><span class="p">)</span> <span class="o">+</span> <span class="mi">7</span><span class="p">;</span>
</div><div class='line' id='LC527'>		<span class="nx">styleValue</span> <span class="o">=</span> <span class="nx">styleValue</span><span class="p">.</span><span class="nx">substr</span><span class="p">(</span><span class="nx">index</span><span class="p">);</span>
</div><div class='line' id='LC528'>		<span class="k">return</span> <span class="nx">styleValue</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="nx">styleValue</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">";"</span><span class="p">))</span>
</div><div class='line' id='LC529'>				<span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="s2">"px"</span><span class="p">,</span> <span class="s1">''</span><span class="p">);</span>
</div><div class='line' id='LC530'>	<span class="p">}</span>
</div><div class='line' id='LC531'>	<span class="k">return</span> <span class="mi">25</span><span class="p">;</span>
</div><div class='line' id='LC532'>
</div><div class='line' id='LC533'><span class="p">}</span><span class="w">
</div><div class='line' id='LC534'></span></div></pre></div>
</div>
</div>

</div>
</div>
<div class='tree_progress'></div>

</div>
<script>
  (function() {
    $(function() {
      return Tree.init();
    });
  
  }).call(this);
</script>
</div>
<script>
  Tree.initHighlightTheme('white')
</script>
</div>
<footer>
<div class='container clearfix'>
<p class='osc_logo'>
<a href="http://www.oschina.net" target="_blank"><img alt="Logo_s2" src="https://www.oschina.net/img/logo_s2.gif" />
</a><a href="http://www.aliyun.com/" target="_blank"><img alt="Aliyun_logo" src="/aliyun_logo.png" />
</a><a href="https://smarticon.geotrust.com/smarticonprofile?Referer=http://git.oschina.net" target="_blank"><img alt="Smarticon" src="/smarticon.gif" />
</a></p>
<ul class='terms'>
<li>
&copy;
<a href="http://www.oschina.net"> 2014 OSChina.NET</a>
</li>
<li><a href="/terms">使用条款</a></li>
<li><a href="/piracy">隐私与安全</a></li>
<li><a href="http://git.oschina.net/oschina/git-osc/wikis/%E5%B8%AE%E5%8A%A9">帮助</a></li>
<li><a href="http://git.oschina.net/oschina/git-osc/wikis/%E5%B8%AE%E5%8A%A9#继续阅读">使用教程</a></li>
<li><a href="http://git.oschina.net/oschina/git-osc/wikis/FAQ">FAQ</a></li>
<li><a href="http://git.oschina.net/progit">ProGit</a></li>
</ul>
</div>
</footer>

</body>
</html>
