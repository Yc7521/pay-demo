// @ts-ignore
import { PageTradingCodeVm, TradingCode, TradingCodeVm } from "../models";

/**
 *
 * @summary Gen id, only test for admin users.
 * @param {*} [options] Override http request option.
 * @deprecated
 * @memberof ApiTradingCodeApiInterface
 */
export declare function genTradingCodeIdTest(options?: {}): Promise<string>;

/**
 *
 * @summary Get a TradingCode by id.
 * @param {string} id
 * @param {*} [options] Override http request option.
 * @memberof ApiTradingCodeApiInterface
 */
export declare function getTradingCode(
  id: string,
  options?: {}
): Promise<TradingCode>;

/**
 *
 * @summary Exist a TradingCode with id.
 * @param {string} id
 * @param {*} [options] Override http request option.
 * @memberof ApiTradingCodeApiInterface
 */
export declare function hasTradingCode(
  id: string,
  options?: {}
): Promise<object>;

/**
 *
 * @summary List TradingCode by userId.
 * @param {number} userId
 * @param {*} [options] Override http request option.
 * @memberof ApiTradingCodeApiInterface
 */
export declare function listRoleRequestByUserId(
  userId: number,
  options?: {}
): Promise<Array<TradingCodeVm>>;

/**
 *
 * @summary List all TradingCode.
 * @param {number} [page]
 * @param {number} [size]
 * @param {*} [options] Override http request option.
 * @memberof ApiTradingCodeApiInterface
 */
export declare function listTradingCode(
  page?: number,
  size?: number,
  options?: {}
): Promise<PageTradingCodeVm>;

/**
 *
 * @summary Remove a TradingCode by id if it\'s Finished.
 * @param {string} id
 * @param {*} [options] Override http request option.
 * @memberof ApiTradingCodeApiInterface
 */
export declare function removeTradingCode(
  id: string,
  options?: {}
): Promise<object>;

/**
 *
 * @summary Submit a TradingCode.
 * @param {TradingCode} [tradingCode]
 * @param {*} [options] Override http request option.
 * @memberof ApiTradingCodeApiInterface
 */
export declare function updateTradingCode(
  tradingCode?: TradingCode,
  options?: {}
): Promise<TradingCodeVm>;
