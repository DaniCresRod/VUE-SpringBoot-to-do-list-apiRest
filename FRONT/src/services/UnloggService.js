import {myUserStore} from '@/services/PiniaStore'

const userStore = myUserStore();

function deleteLog(){
    userStore.uEmail = '';
    userStore.uName = '';
    userStore.uPass = '';
    userStore.uFavs = '';
}

export default deleteLog;

