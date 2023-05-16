import request from "@/utils/request";

const PAY_API_PREFIX = `/pay-api`

/**
 *
 * @summary Delete user.
 * @param {number} id
 * @param {*} [options] Override http request option.
 */
export function deleteUser(id, options = {}) {
  const path = `${PAY_API_PREFIX}/user/{id}`.replace(
    `{${"id"}}`,
    encodeURIComponent(String(id))
  );
  const params = {};

  return request({
    url: path,
    method: "DELETE",
    params,
    ...options,
  });
}

/**
 *
 * @summary Login.
 * @param {LoginVm | SecretLoginVm} [loginVm]
 * @param {*} [options] Override http request option.
 */
export function login(loginVm = null, options = {}) {
  const path = `${PAY_API_PREFIX}/login`;
  const params = {};

  return request({
    url: path,
    method: "POST",
    params,
    data: loginVm,
    ...options,
  });
}

/**
 *
 * @summary Logout.
 * @param {*} [options] Override http request option.
 */
export function logout(options = {}) {
  const path = `${PAY_API_PREFIX}/logout`;
  const params = {};

  return request({
    url: path,
    method: "GET",
    params,
    ...options,
  });
}

/**
 *
 * @summary Register.
 * @param {LoginVm} [loginVm]
 * @param {*} [options] Override http request option.
 */
export function register(loginVm = null, options = {}) {
  const path = `${PAY_API_PREFIX}/register`;
  const params = {};

  return request({
    url: path,
    method: "POST",
    params,
    data: loginVm,
    ...options,
  });
}
