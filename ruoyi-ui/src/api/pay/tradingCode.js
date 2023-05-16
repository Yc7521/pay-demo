import request from "@/utils/request";

const PAY_API_PREFIX = `/pay-api`

/**
 *
 * @summary Gen id, only test for admin users.
 * @param {*} [options] Override http request option.
 * @deprecated
 */
export function genTradingCodeIdTest(options = {}) {
  const path = `${PAY_API_PREFIX}/code/getId`;
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
 * @summary Get a TradingCode by id.
 * @param {string} id
 * @param {*} [options] Override http request option.
 */
export function getTradingCode(id, options = {}) {
  const path = `${PAY_API_PREFIX}/code/{id}`.replace(
    `{${"id"}}`,
    encodeURIComponent(String(id))
  );
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
 * @summary Exist a TradingCode with id.
 * @param {string} id
 * @param {*} [options] Override http request option.
 */
export function hasTradingCode(id, options = {}) {
  const path = `${PAY_API_PREFIX}/code/has/{id}`.replace(
    `{${"id"}}`,
    encodeURIComponent(String(id))
  );
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
 * @summary List TradingCode by userId.
 * @param {number} userId
 * @param {*} [options] Override http request option.
 */
export function listRoleRequestByUserId(userId, options = {}) {
  const path = `${PAY_API_PREFIX}/code/user/{userId}`.replace(
    `{${"userId"}}`,
    encodeURIComponent(String(userId))
  );
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
 * @summary List all TradingCode.
 * @param {number} [page]
 * @param {number} [size]
 * @param {*} [options] Override http request option.
 */
export function listTradingCode(page = null, size = null, options = {}) {
  const path = `${PAY_API_PREFIX}/code`;
  const params = {
    page,
    size,
  };

  return request({
    url: path,
    method: "GET",
    params,
    ...options,
  });
}

/**
 *
 * @summary Remove a TradingCode by id if it\'s Finished.
 * @param {string} id
 * @param {*} [options] Override http request option.
 */
export function removeTradingCode(id, options = {}) {
  const path = `${PAY_API_PREFIX}/code/{id}`.replace(
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
 * @summary Submit a TradingCode.
 * @param {TradingCode} [tradingCode]
 * @param {*} [options] Override http request option.
 */
export function updateTradingCode(tradingCode = null, options = {}) {
  const path = `${PAY_API_PREFIX}/code`;
  const params = {};

  return request({
    url: path,
    method: "POST",
    params,
    data: tradingCode,
    ...options,
  });
}
