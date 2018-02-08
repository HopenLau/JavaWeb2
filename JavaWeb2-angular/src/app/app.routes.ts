import {RouterModule} from "@angular/router";

import {AuthService} from "./service/AuthService";

import {LoginComponent} from "./login/login.components";
import {HomeComponent} from "./home/home.component";
import {UserComponent} from "./home/user/user.component";
import {UserListComponent} from "./home/user/list/user.list.component";
import {CenteralComponent} from "./home/centeral/centeral.component";
import {UserAddComponent} from "./home/user/add/user.add.component";
import {UserModifyComponent} from "./home/user/modify/user.modify.component";
import {UserDetailComponent} from "./home/user/detail/user.detail.component";
import {UserRoleAssignmentComponent} from "./home/user/roleAssignment/user.role.assignment.component";
import {RoleComponent} from "./home/role/role.component";
import {RoleListComponent} from "./home/role/list/role.list.component";
import {RoleAddComponent} from "./home/role/add/role.add.component";
import {RoleDetailComponent} from "./home/role/detail/role.detail.component";
import {RoleModifyComponent} from "./home/role/modify/role.modify.component";
import {MenuComponent} from "./home/menu/menu.component";
import {MenuListComponent} from "./home/menu/list/menu.list.component";

const APP_ROUTES = [
    {path:'',component:LoginComponent},//默认登录页面
    {path:'login',component:LoginComponent},//登录页面
    {path:'web',component:HomeComponent,children:[
        {path:'',component:CenteralComponent,canActivate:[AuthService]},
        {path:'sys/user',component:UserComponent,children:[
            {path:'list',component:UserListComponent,canActivate:[AuthService]},//用户列表页面
            {path:'add',component:UserAddComponent,canActivate:[AuthService]},//新增用户页面
            {path:'modify',component:UserModifyComponent,canActivate:[AuthService]},//修改用户页面
            {path:'detail',component:UserDetailComponent,canActivate:[AuthService]},//用户详情页面
            {path:'roleAssignment',component:UserRoleAssignmentComponent,canActivate:[AuthService]},//用户角色分配页面
            {path:'**',redirectTo:'/web',pathMatch:'full'}
        ],canActivate:[AuthService]},
        {path:'sys/role',component:RoleComponent,children:[
            {path:'list',component:RoleListComponent,canActivate:[AuthService]},//角色列表页面
            {path:'add',component:RoleAddComponent,canActivate:[AuthService]},//新增角色页面
            {path:'modify',component:RoleModifyComponent,canActivate:[AuthService]},//修改角色页面
            {path:'detail',component:RoleDetailComponent,canActivate:[AuthService]},//角色详情页面
            {path:'**',redirectTo:'/web',pathMatch:'full'}
        ],canActivate:[AuthService]},
        {path:'sys/module',component:MenuComponent,children:[
            {path:'list',component:MenuListComponent,canActivate:[AuthService]},//模块列表页面
            {path:'**',redirectTo:'/web',pathMatch:'full'}
        ],canActivate:[AuthService]},
        {path:'**',redirectTo: '/web', pathMatch: 'full'}
    ],canActivate:[AuthService]},//home页面
    {path:'**',redirectTo: '/', pathMatch: 'full'}//访问任何不存在的URL都将跳回登录页面
];

//路由有两种策略，HashLocationStrategy和PathLocationStrategy，我这里用的是HashLocationStrategy
export const AppRoutes = RouterModule.forRoot(APP_ROUTES,{useHash:true});
