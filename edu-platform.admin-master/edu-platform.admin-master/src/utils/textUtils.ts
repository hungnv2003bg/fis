export const validateEmail = (email: string) => {
  const pattern = /^[a-z][a-z0-9_\.]{5,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$/g;

  return email.match(pattern);
}

export const validatePassword = (password: string) => {
  const pattern = /^(?=.*\d)(?=.*[a-z])+.{8,}$/;

  return password.match(pattern);
}