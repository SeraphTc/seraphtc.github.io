(window.webpackJsonp=window.webpackJsonp||[]).push([[5],{62:function(a,r,t){"use strict";t.r(r);var s=t(0),e=Object(s.a)({},function(){this.$createElement;this._self._c;return this._m(0)},[function(){var a=this,r=a.$createElement,t=a._self._c||r;return t("div",{staticClass:"content"},[t("h1",{attrs:{id:"erp直连项目设计"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#erp直连项目设计","aria-hidden":"true"}},[a._v("#")]),a._v(" ERP直连项目设计")]),t("h2",{attrs:{id:"一、背景"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#一、背景","aria-hidden":"true"}},[a._v("#")]),a._v(" 一、背景")]),t("p",[a._v("预订订单会通过多种渠道进行分发，dispatch模板负责分发策略，对接各渠道模块(如声讯平台、短信平台等)，渠道模块执行实际的分发。")]),t("p",[a._v("目前需要新增渠道，通过开放平台推送给ERP厂商，所以需要设计新的渠道模块去支撑订单分发任务的执行，即开放平台 - 订单（resv-vendor-order，简称vendor-order）模块。")]),t("p"),t("h2",{attrs:{id:"二、主要业务过程"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#二、主要业务过程","aria-hidden":"true"}},[a._v("#")]),a._v(" 二、主要业务过程")]),t("h3",{attrs:{id:"_1-push消息（新订单、订单状态改变）"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-push消息（新订单、订单状态改变）","aria-hidden":"true"}},[a._v("#")]),a._v(" 1.push消息（新订单、订单状态改变）")]),t("img",{attrs:{src:"img1/d6-1.png"}}),t("p"),t("h3",{attrs:{id:"_2-接收回调消息（被告知接单、拒单、到店、未到店等）"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_2-接收回调消息（被告知接单、拒单、到店、未到店等）","aria-hidden":"true"}},[a._v("#")]),a._v(" 2.接收回调消息（被告知接单、拒单、到店、未到店等）")]),t("img",{attrs:{src:"img1/d6-2.png"}}),t("h2",{attrs:{id:"三、领域设计"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#三、领域设计","aria-hidden":"true"}},[a._v("#")]),a._v(" 三、领域设计")]),t("p",[a._v("vendor-order主要push订单消息以及接受第三方订单回调消息，因此两个核心领域对象：请求消息 & 回调消息，系统内的主要操作，都是基于这两种消息进行执行、重试的。")]),t("img",{attrs:{src:"img1/d6-3.png"}}),t("h2",{attrs:{id:"四、核心流程检验"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#四、核心流程检验","aria-hidden":"true"}},[a._v("#")]),a._v(" 四、核心流程检验")]),t("h3",{attrs:{id:"_1-push"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-push","aria-hidden":"true"}},[a._v("#")]),a._v(" 1.push")]),t("img",{attrs:{src:"img1/d6-4.png"}}),t("h3",{attrs:{id:"_2-callback"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_2-callback","aria-hidden":"true"}},[a._v("#")]),a._v(" 2.callback")]),t("img",{attrs:{src:"img1/d6-5.png"}}),t("h2",{attrs:{id:"五、服务质量关注点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#五、服务质量关注点","aria-hidden":"true"}},[a._v("#")]),a._v(" 五、服务质量关注点")]),t("h3",{attrs:{id:"_1-orderpush高可用"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-orderpush高可用","aria-hidden":"true"}},[a._v("#")]),a._v(" 1.OrderPush高可用")]),t("p",[a._v("重试：根据执行状态status，由job驱动进行重试（10秒一次），防止第三方服务间歇性不可用")]),t("h3",{attrs:{id:"_2-orderpush高一致"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_2-orderpush高一致","aria-hidden":"true"}},[a._v("#")]),a._v(" 2.OrderPush高一致")]),t("p",[a._v("补偿（本次不做，第三方未提供查询订单状态接口）：根据recheck_status检查推送后的订单状态是否符合预期，不符合时重试。")]),t("h3",{attrs:{id:"_3-整体服务高可用"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_3-整体服务高可用","aria-hidden":"true"}},[a._v("#")]),a._v(" 3.整体服务高可用")]),t("p",[a._v("业务打点、监控")])])}],!1,null,null,null);r.default=e.exports}}]);