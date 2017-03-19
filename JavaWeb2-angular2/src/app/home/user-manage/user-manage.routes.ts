import {Routes} from '@angular/router';

import {UserManageListComponent} from "./list/user-manage.list.component";
import {UserManageAddComponent} from "./add/user-manage.add.component";
import {AuthService} from "../../service/auth/AuthService";

export const UserManageRoutes:Routes = [
    {path:'userManage/list',component:UserManageListComponent,canActivate:[AuthService]},
    {path:'userManage/add',component:UserManageAddComponent,canActivate:[AuthService]}
];