import {notification} from "antd";

export const fireNotification = (type: string, message: string, description: string) => {
  notification[type]({
    message: message,
    description: description,
    placement: 'top'
  });
}