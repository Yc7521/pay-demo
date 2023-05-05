import request from '@/utils/request'

// 查询用户ApiKey列表
export function listApikey(query) {
  return request({
    url: '/goods/apikey/list',
    method: 'get',
    params: query
  })
}

// 查询用户ApiKey详细
export function getApikey(id) {
  return request({
    url: '/goods/apikey/' + id,
    method: 'get'
  })
}

// 新增用户ApiKey
export function addApikey(data) {
  return request({
    url: '/goods/apikey',
    method: 'post',
    data: data
  })
}

// 修改用户ApiKey
export function updateApikey(data) {
  return request({
    url: '/goods/apikey',
    method: 'put',
    data: data
  })
}

// 删除用户ApiKey
export function delApikey(id) {
  return request({
    url: '/goods/apikey/' + id,
    method: 'delete'
  })
}
